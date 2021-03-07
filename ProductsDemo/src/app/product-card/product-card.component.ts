import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from '../classes/CartItem';
import { Product } from '../classes/Product';
import { BasicDataService } from '../services/basic-data.service';


@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss']
})

export class ProductCardComponent implements OnInit {
  @Input()
  ItemDetails!: Product;
  @Input()
  ItemImage!: string;
  rareProduct: boolean;
  ItemTitle: string = "";
  sizeTitle: number =40;
  sizeDescription: number =200;
  qty:number= 1;
  enableAddButton:boolean = true;

  constructor(private _router: Router,public basicDataService: BasicDataService) { }

  ngOnInit() {
    this.rareProduct = (this.ItemDetails.rareProduct=1)?true:false;
    this.ItemTitle = String(this.ItemDetails.productName);
    this.ItemTitle =  this.ItemTitle.substring(0, this.sizeTitle).padEnd(this.sizeTitle, ' ');
  }

  public goToDetails(){
    this.basicDataService.selectedProduct =  this.ItemDetails;
    this._router.navigate(['./productPriceList']);     
  }

  //Adding items to cart
  public addToCart(){
    let cartItem: CartItem = new CartItem();
    cartItem.productId = this.ItemDetails.productId;
    cartItem.productName = this.ItemDetails.productName;
    cartItem.cartoonSize = this.ItemDetails.cartoonSize;
    cartItem.cartoonPrice = this.ItemDetails.cartoonPrice;
    cartItem.imageUrl = this.ItemDetails.imageUrl;
    cartItem.itemCount = this.qty;
    cartItem.price = 0;
    this.basicDataService.CartItems[this.basicDataService.CartItems.length] = cartItem;
    this.qty = 0;
    this.disableAdd();
  }

  // validating add button
  public disableAdd() {
    if (this.qty > 0) {
      this.enableAddButton = true;
    } else {
      this.enableAddButton = false;
    }

  }

}