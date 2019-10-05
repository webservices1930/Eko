import { Component, OnInit } from '@angular/core';
import { Transporte } from '../../shared/model/Producto/Transporte';
import { Disponibilidad } from '../../shared/model/Disponibilidad';
import { NgForm } from '@angular/forms';
import { ProductService } from 'src/app/shared/services/product/product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  public nTrayecto: string = '';
  public nTransporte: Transporte = new Transporte();
  public nDisponibilidad: Disponibilidad = new Disponibilidad();

  constructor(private productService: ProductService) {}

  ngOnInit() {}

  onSubmit() {
    this.nTransporte.disponibilidad.push(this.nDisponibilidad);
    this.nTransporte.trayecto.push(this.nTrayecto);

    this.productService.agregarProducto(this.nTransporte)
      .subscribe(result => {
        alert('Producto agregado exitosamente')
      },
      error =>{
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }
}
