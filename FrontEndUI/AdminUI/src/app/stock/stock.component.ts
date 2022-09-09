import { NgForOf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  stocks?: any[];;

  constructor(http: HttpClient){
    
    http.get<any>('http://localhost:8081/api/v1/allocation-check/get-all').subscribe(response =>{
      this.stocks = response;
      // stock = this.stocks[0];
      console.log(this.stocks);
    });
  }
  

  ngOnInit(): void {
  }

}
