import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/classes/Product';
import { BasicDataService } from 'src/app/services/basic-data.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  productList: Product[] = []; 
  constructor(public basicDataService: BasicDataService) { }

  ngOnInit(): void {    
    this.productList = this.basicDataService.productData;
  }

}
