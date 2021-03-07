import { Component, OnInit, ViewChild } from '@angular/core';
import { BasicDataService } from 'src/app/services/basic-data.service';
import { CartItem } from '../../classes/CartItem';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  subTotal:number;
  total:number;
  qty:number;
  cartoonCount:number;
  ItemsList: CartItem[]=[];

  constructor(public basicDataService: BasicDataService) { }
    
  ngOnInit(): void {
    
    this.ItemsList= this.basicDataService.CartItems;
    this.basicDataService. calculateCartTotal();
  }

}
