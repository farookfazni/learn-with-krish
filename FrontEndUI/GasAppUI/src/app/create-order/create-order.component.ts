import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {
  

  constructor(private http: HttpClient) { }

  createOrder(input: HTMLInputElement){
    let post = {allocAmount: input.value};
    // console.log(post);
    this.http.post('http://localhost:8080/api/v1/orders/data',post).subscribe(response => {
      console.log(response);
    });
  }

  reloadPage(){
    window.location.reload();
  }

  ngOnInit(): void {
  }

}
