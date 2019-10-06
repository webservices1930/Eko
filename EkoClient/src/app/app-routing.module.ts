import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductFormComponent } from './form/product-form/product-form.component';
import { ReservasComponent} from './reservas/reservas.component';


const routes: Routes = [
  { path: 'product/add', component: ProductFormComponent },
  { path: 'reserva', component: ReservasComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
