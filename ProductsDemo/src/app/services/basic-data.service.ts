import { Injectable } from '@angular/core';
import { CartItem } from '../classes/CartItem';
import { ItemPrice } from '../classes/ItemPrice';
import { Product } from '../classes/Product';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class BasicDataService extends DataService{
 url:string = "http://localhost:8080/";

  private _itemData: ItemPrice[] = [];
  public get itemData(): ItemPrice[] {
    return this._itemData;
  }
  public set itemData(value: ItemPrice[]) {
    this._itemData = value;
  }

  private _productData: Product[] = [];
  public get productData(): Product[] {
    return this._productData;
  }
  public set productData(value: Product[]) {
    this._productData = value;
  }

  private _selectedProduct: Product;
  public get selectedProduct(): Product {
    return this._selectedProduct;
  }
  public set selectedProduct(value: Product) {
    this._selectedProduct = value;
  }
  private _CartItems: CartItem[] = [];
  public get CartItems(): CartItem[] {
    return this._CartItems;
  }
  public set CartItems(value: CartItem[]) {
    this._CartItems = value;
  }
  private _cartItemTotal: number = 0;
  public get cartItemTotal(): number {
    return this._cartItemTotal;
  }
  public set cartItemTotal(value: number) {
    this._cartItemTotal = value;
  }

  public calculateCartTotal() {
    this.cartItemTotal = 0;
    this.CartItems.forEach(element => {
      this.cartItemTotal = (this.cartItemTotal + element.price);
      this.cartItemTotal = Math.round(this.cartItemTotal * 100) / 100;
    });
  }

  public dummyData(){
    return super.getData(this.url+"product/dummy_data");
  }
  public getAllProducts(){
    return super.getData(this.url+"product/all_products");
  }
  public getProductPriceList(productId: number, qty:number){
    return super.getPrice(this.url+"product/prodcut_price_list", productId, qty);
  }
  public getProductPrice(productId: number, qty:number){
    return super.getPrice(this.url+"product/prodcut_price", productId, qty);
  }
  

}
