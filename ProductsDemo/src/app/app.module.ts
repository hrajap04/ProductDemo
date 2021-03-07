import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './ui/products/products.component';
import { ProductsPriceListComponent } from './ui/products-price-list/products-price-list.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './ui/header/header.component';
import { HomeComponent } from './ui/home/home.component';
import { ProductCardComponent } from './product-card/product-card.component';
import { CartComponent } from './ui/cart/cart.component';
import { FormsModule } from '@angular/forms';
import { CartItemsComponent } from './cart-items/cart-items.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductsPriceListComponent,
    HeaderComponent,
    HomeComponent,
    ProductCardComponent,
    CartComponent,
    CartItemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
