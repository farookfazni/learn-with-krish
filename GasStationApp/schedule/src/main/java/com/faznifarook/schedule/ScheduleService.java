package com.faznifarook.schedule;

//import com.fatboyindustrial.gsonjavatime.Converters;
import com.faznifarook.schedule.entity.AllocationCheckHistory;
import com.faznifarook.schedule.entity.Schedule;
import com.google.gson.*;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

//    KafkaTemplate<String, AllocationCheckHistory> kafkaTemplate;

    @KafkaListener(topics = "secondTopic", groupId = "groupId")
    public void scheduleOrder(String data){

//      todo: Reciving without DateAndTime Need To recive With DateAndTime

        Gson g = new Gson();
//        GsonBuilder gsonBuilder  = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
//
//        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
//        Gson g = gsonBuilder.setPrettyPrinting().create();
        AllocationCheckHistory a = g.fromJson(data,AllocationCheckHistory.class);
//        LocalDateTime createdDate = a.getCreatedAt().get(0);
//        Gson gg = new Gson();
//        String json = gg.toJson(a.getCreatedAt());
        System.out.println(a);
//        System.out.println(json);

//        Schedule schedule = Schedule.builder()
//                .orderId(a.getOrderId())
//                .allocAmount(a.getAllocAmmount())
//                .status("Order Scheduled")
//                .scheduleTime(LocalDateTime.now().plusDays(5))
//                .build();
//        scheduleRepository.save(schedule);
    }
}
