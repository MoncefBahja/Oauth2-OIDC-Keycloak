import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './ui/products/products'
import {Customer} from './ui/customer/customer'

const routes: Routes = [

  {path : "products" ,component :ProductsComponent},
  {path : "customers" , component: Customer}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
