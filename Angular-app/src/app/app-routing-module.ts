import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './ui/products/products'
import {Customer} from './ui/customer/customer'
import {AuthGuard} from './guards/auth-guard';

const routes: Routes = [

  {path : "products" ,component :ProductsComponent,canActivate: [AuthGuard], data:{role:["ADMIN"]}},
  {path : "customers" , component: Customer,canActivate: [AuthGuard], data:{role:["USER"]}}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
