package com.faznifarook.allocation;

import com.faznifarook.allocation.entity.AllocationCheckHistory;
import com.faznifarook.allocation.entity.Order;
import com.faznifarook.allocation.entity.Stock;
import com.faznifarook.allocation.repo.AllocationCheckHistoryRepositry;
//import com.faznifarook.allocation.repo.OrderRepository;
import com.faznifarook.allocation.repo.StockRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;
    private final StockRepository stockRepository;

//    Read the Kafka Object
    @KafkaListener(topics = "mainTopic", groupId = "groupId")
    public void listenerForOrder (String data) {
//        Converting Sting to Json of Paticular Object
        Gson g = new Gson();
        Order o = g.fromJson(data,Order.class);

//        finding the last entered value
        List<Stock> st = stockRepository.findByIdDESC();
//        Getting the object from ArrayList
        Stock sto = st.get(0);

//        Getting the values that we need to compare
        Integer alreadyAllocatedStock = sto.getAllocatedAmount();
        Integer availableStock = sto.getAvailableStock();
        Integer allocationstock = o.getAllocAmount();

// Saving the values to allocation History table by checking Weather the Stock is available or not
        System.out.println("Listener received json: " + o);
        AllocationCheckHistory allocationCheckHistory = AllocationCheckHistory
                .builder()
                .orderId(o.getOrderId())
                .allocAmmount(o.getAllocAmount())
                .status(o.getStatus())
                .createdAt(LocalDateTime.now())
                .isStockAvailable(checkStock(availableStock,allocationstock,alreadyAllocatedStock)) // Checking whether the stock is available or not
                .build();
        allocationCheckHistoryRepositry.save(allocationCheckHistory);
    }

//    updating Stock From PostMaping From Admin Side (Intial Built)
//    todo: Make sure the Admin the only person can change this
    public void stockUpdate(UpdateStockmessage updateStockmessage){
        Stock stock = Stock.builder()
                .allocatedAmount(updateStockmessage.allocatedAmount())
                .availableStock(updateStockmessage.availableStock())
                .build();
        stockRepository.save(stock);
    }

    // Function for Checking the Stock available or not and updating stock Table
    public Boolean checkStock(Integer availableStock,Integer allocationstock, Integer alreadyAllocatedStock){
        if (availableStock >=  allocationstock){
            Integer balanceStock = availableStock-allocationstock;
            Integer TotalAllocation = alreadyAllocatedStock+allocationstock;
            Stock stock = Stock.builder()
                    .allocatedAmount(TotalAllocation)
                    .availableStock(balanceStock)
                    .build();
            stockRepository.save(stock);
            return true;
        }
        else
            return false; // todo: throw an error if stock is not available
    }

//    public void placeCheck(MessageRequest messageRequest){
//        AllocationCheckHistory allocationCheckHistory = AllocationCheckHistory
//                .builder()
//                .orderId(messageRequest.)
//                .build();
//    }
}
