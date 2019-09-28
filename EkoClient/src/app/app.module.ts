import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductFormComponent } from './form/product-form/product-form.component';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { NgxSoapModule } from 'ngx-soap';


@NgModule({
  declarations: [
    AppComponent,
    ProductFormComponent
  ],
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSoapModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
