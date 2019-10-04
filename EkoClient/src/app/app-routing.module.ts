import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductFormComponent } from './form/product-form/product-form.component';
import { LoginComponent } from './user/login/login.component';
import { MarketPlaceComponent } from './market-place/market-place.component';
import { AuthGuard } from './guard/auth.guard';
import { RegisterComponent } from './user/register/register.component';

const routes: Routes = [
  { path: 'product/add', component: ProductFormComponent, canActivate: [AuthGuard] },
  { path: 'user/login', component: LoginComponent },
  { path: 'user/register', component: RegisterComponent },
  { path: '', component: MarketPlaceComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
