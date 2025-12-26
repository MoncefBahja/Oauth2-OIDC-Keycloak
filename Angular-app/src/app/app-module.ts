import {APP_INITIALIZER, NgModule, provideBrowserGlobalErrorListeners} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { ProductsComponent } from './ui/products/products';
import { Customer } from './ui/customer/customer';
import { HttpClientModule } from '@angular/common/http';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'app-key',
        clientId: 'app-client'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: undefined, // <-- désactive l'iframe
        checkLoginIframe: false,
       /* silentCheckSsoRedirectUri:
          window.location.origin + '../assets/silent-check-sso.html'*/
      }
    });
}
@NgModule({
  declarations: [
    App,
    ProductsComponent,
    Customer
  ],
  imports: [
    BrowserModule,
    AppRoutingModule , HttpClientModule , KeycloakAngularModule
  ],
  /*providers: [
    provideBrowserGlobalErrorListeners()
  ],*/
  providers: [
    {provide : APP_INITIALIZER, useFactory : initializeKeycloak, multi :true, deps : [KeycloakService]}
  ],
  bootstrap: [App]
})
export class AppModule { }
