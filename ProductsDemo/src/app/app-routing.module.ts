import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './ui/home/home.component';
import { ProductsPriceListComponent } from './ui/products-price-list/products-price-list.component';
import { ProductsComponent } from './ui/products/products.component';
import { CartComponent } from './ui/cart/cart.component';

const routes: Routes = [
  {path:'', component:HomeComponent, pathMatch: 'full'},
  {path:'productPriceList', component:ProductsPriceListComponent},
  {path:'productsList', component:ProductsComponent},
  {path:'cart', component:CartComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
