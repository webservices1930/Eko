import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductFormComponent } from './form/product-form/product-form.component';
import { LoginComponent } from './user/login/login.component';
import { MarketPlaceComponent } from './market-place/market-place.component';
import { RegisterComponent } from './user/register/register.component';
import { NoAuthGuard } from './guard/no-auth/no-auth.guard';
import { AuthGuard } from './guard/auth/auth.guard';

const routes: Routes = [
  { path: 'product/add', component: ProductFormComponent, canActivate: [NoAuthGuard] },
  { path: 'user/login', component: LoginComponent, canActivate: [AuthGuard] },
  { path: 'user/register', component: RegisterComponent, canActivate: [AuthGuard] },
  { path: 'home', component: MarketPlaceComponent, canActivate: [NoAuthGuard] }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
