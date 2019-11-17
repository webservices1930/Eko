import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductFormComponent } from './form/product-form/product-form.component';
import { LoginComponent } from './user/login/login.component';
import { MarketPlaceComponent } from './market-place/market-place.component';
import { RegisterComponent } from './user/register/register.component';
import { NoAuthGuard } from './guard/no-auth/no-auth.guard';
import { AuthGuard } from './guard/auth/auth.guard';
import { ProfileComponent } from './user/profile/profile.component';
import { EditProfileComponent } from './user/edit-profile/edit-profile.component';
import { ProductViewComponent } from './product/product-view/product-view.component';
import { CarViewComponent } from './car/car-view/car-view.component';
import { ProductFormEditComponent } from './form/product-form-edit/product-form-edit.component';
import { TwitterComponent } from './twitter/twitter.component';

const routes: Routes = [
  { path: 'product/add', component: ProductFormComponent },
  { path: 'user/login', component: LoginComponent, canActivate: [AuthGuard] },
  { path: 'user/register', component: RegisterComponent, canActivate: [AuthGuard] },
  { path: 'user/profile', component: ProfileComponent, canActivate: [NoAuthGuard] },
  { path: 'user/edit', component: EditProfileComponent, canActivate: [NoAuthGuard] },
  { path: 'home', component: MarketPlaceComponent, canActivate: [NoAuthGuard] },
  { path: 'product/add', component: ProductFormComponent },
  { path: 'product/:tipo/:id', component: ProductViewComponent },
  { path: 'market-place', component: MarketPlaceComponent },
  { path: 'product-edit/:id', component: ProductFormEditComponent },
  { path: 'car', component: CarViewComponent },
  { path: 'twitter', component: TwitterComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
