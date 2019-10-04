import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductFormComponent } from './form/product-form/product-form.component';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { NgxSoapModule } from 'ngx-soap';
import { LoginComponent } from './user/login/login.component';
import { MenuComponent } from './nav/menu/menu.component';

import { ReactiveFormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { MarketPlaceComponent } from './market-place/market-place.component';
import { RegisterComponent } from './user/register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    ProductFormComponent,
    LoginComponent,
    MenuComponent,
    MarketPlaceComponent,
    RegisterComponent
  ],
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSoapModule,
    ReactiveFormsModule
  ],
  providers: [
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
