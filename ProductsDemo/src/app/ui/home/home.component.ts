import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/classes/Product';
import { BasicDataService } from 'src/app/services/basic-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private _router: Router,public basicDataService: BasicDataService) { }

  ngOnInit(): void {
    //this.loadData();
  }

  //to load initial data
  async loadData() {
    this.basicDataService.dummyData().
      subscribe((dataAdded: string) => {       
        console.log(dataAdded);
        this.basicDataService.getAllProducts().
        subscribe((products: Product[]) => {
          this.basicDataService.productData = products;
          console.log(this.basicDataService.productData);
          this.goToProducts();
        });
      });
    
  

  }
  public goToProducts(){
    this._router.navigate(['./productsList']);
  }
}
