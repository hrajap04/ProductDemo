import { Component, OnInit } from '@angular/core';
import { ItemPrice } from 'src/app/classes/ItemPrice';
import { Product } from 'src/app/classes/Product';
import { ProductCardComponent } from 'src/app/product-card/product-card.component';
import { BasicDataService } from 'src/app/services/basic-data.service';

@Component({
  selector: 'app-products-price-list',
  templateUrl: './products-price-list.component.html',
  styleUrls: ['./products-price-list.component.scss']
})
export class ProductsPriceListComponent implements OnInit {

  itemPriceList: ItemPrice[] = [];
  product: Product;
  displayCount: number = 50;
  constructor(public basicDataService: BasicDataService) { }


  ngOnInit(): void {
    this.product = this.basicDataService.selectedProduct;
    this.basicDataService.selectedProduct = null;
    this.loadData();
  }

  //load the price list
  async loadData() {
    this.basicDataService.getProductPriceList(this.product.productId, this.displayCount).
      subscribe((itempriceList: ItemPrice[]) => {
        this.basicDataService.itemData = itempriceList;
        this.itemPriceList = itempriceList;
      });
  }
}
