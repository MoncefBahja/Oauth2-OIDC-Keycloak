import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { ProductsComponent } from './ui/products/products';
import { Customer } from './ui/customer/customer';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    App,
    ProductsComponent,
    Customer
  ],
  imports: [
    BrowserModule,
    AppRoutingModule , HttpClientModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
