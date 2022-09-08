import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OrdersService } from './orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders?: any[];
  title = "List of Orders";
  // orders;

  // constructor(service: OrdersService) {
  //   this.orders = service.getOrders();
  // }
  constructor(http: HttpClient){
    
    http.get<any>('http://localhost:8080/api/v1/orders/get-all').subscribe(response =>{
      this.orders = response;
    });
  }

  ngOnInit(): void {
  }

}
