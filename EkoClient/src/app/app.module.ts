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

import { AgmCoreModule } from '@agm/core';

import { ReactiveFormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { MarketPlaceComponent } from './market-place/market-place.component';
import { RegisterComponent } from './user/register/register.component';
import { ProfileComponent } from './user/profile/profile.component';
import { EditProfileComponent } from './user/edit-profile/edit-profile.component';
import { ProductViewSmallComponent } from './product/product-view-small/product-view-small.component';
import { ProductViewComponent } from './product/product-view/product-view.component';
import { CarViewComponent } from './car/car-view/car-view.component';
import { QuestionFormComponent } from './question/question-form/question-form.component';
import { RateFormComponent } from './rate/rate-form/rate-form.component';
import { ProductFormEditComponent } from './form/product-form-edit/product-form-edit.component';
import { TwitterComponent } from './twitter/twitter.component';

import { QuestionViewComponent } from './question/question-view/question-view.component';
import { AgmDirectionModule } from 'agm-direction';
import { WeatherComponent } from './weather/weather.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductFormComponent,
    LoginComponent,
    MenuComponent,
    MarketPlaceComponent,
    RegisterComponent,
    ProfileComponent,
    EditProfileComponent,
    ProductViewSmallComponent,
    ProductViewComponent,
    CarViewComponent,
    QuestionFormComponent,
    RateFormComponent,
    ProductFormEditComponent,
    TwitterComponent,
    QuestionViewComponent,
    WeatherComponent
  ],
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSoapModule,
    ReactiveFormsModule,
    AgmDirectionModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBmxwM96lYp-weLUJO-D_73HhgHXqdckuk'
    })
  ],
  providers: [
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
