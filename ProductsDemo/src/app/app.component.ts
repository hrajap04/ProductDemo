import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Product } from './classes/Product';
import { BasicDataService } from './services/basic-data.service';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ProductsDemo';
  constructor(public basicDataService: BasicDataService, dataService: DataService,private titleService: Title){}

  ngOnInit(){
     this.loadData();
  }
  async loadData() {    
    this.basicDataService.getAllProducts().
      subscribe((products: Product[]) => {
        this.basicDataService.productData = products;
        console.log(this.basicDataService.productData);
      });

  }
}
