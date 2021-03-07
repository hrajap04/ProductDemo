import { Component, Input, OnInit } from '@angular/core';
import { CartItem } from '../classes/CartItem';
import { BasicDataService } from '../services/basic-data.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.scss']
})
export class CartItemsComponent implements OnInit {

  @Input()
  cartItem: CartItem;
  qty:number= 1;
  selectedUnit:string ="0";
  unitPrce:number;

  subTotal:number;
  total:number;
  
  cartoonCount:number;
  ItemsList: CartItem[]=[];
  constructor(public basicDataService: BasicDataService) { }
  

  ngOnInit(): void {
    this.qty = this.cartItem.itemCount;
    this.setUnitPrice();
    this.getPrice(this.cartItem.productId, this.qty);
  }

  //reset the units
  public setUnits(unit: string) {
    this.selectedUnit = unit;
    this.reCalculate();
    this.setUnitPrice();
  }

  //set Unit price
  public setUnitPrice() {
    if (this.selectedUnit == '1') {
      this.unitPrce = this.cartItem.cartoonPrice;
    } else {
      this.unitPrce = this.cartItem.cartoonPrice/this.cartItem.cartoonSize*1.3;
    }
  }

  //recalculate subtotal
  public reCalculate(){
    console.log("reCalculate");
    let DummyQty:number;
    if (this.selectedUnit=='1') {
      DummyQty = this.qty * this.cartItem.cartoonSize;
    } else {
      DummyQty = this.qty;
    }
    this.getPrice(this.cartItem.productId, DummyQty);
  }

  public removeItem(){
    // delete this.basicDataService.CartItems[this.basicDataService.CartItems.findIndex(data => data.productId == this.cartItem.productId)];
  }

  //updating the Original cart data
  public updateCartData(qty:number) {
    let index: number = this.basicDataService.CartItems.findIndex(data => data.productId == this.cartItem.productId);
     this.basicDataService.CartItems[index].itemCount = qty;
     this.cartItem.itemCount = qty;
     this.basicDataService.CartItems[index].price = this.subTotal;
     this.cartItem.price =  this.subTotal;
  }

  //get the price from the server
  async getPrice(productId:number, qty:number){
    this.basicDataService.getProductPrice(productId, qty).
    subscribe((subTotal: number) => {
      this.subTotal = subTotal;
      this.updateCartData(qty);
      this.basicDataService. calculateCartTotal();      
    });
    
  }

}
