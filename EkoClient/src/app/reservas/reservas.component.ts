import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Transporte } from '../shared/model/Producto/Transporte';
import { ProductService } from 'src/app/shared/services/product-service.service';
import { Reserva } from '../shared/model/Reserva';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.scss']
})
export class ReservasComponent implements OnInit {

  //private nFechas: string = '';
  private reserva: Reserva = new Reserva();
  //private plan: Plan = new Plan(); reserva para el plan
  //private cliente: Cliente = new Ciente();reserva de cada cliente

  constructor(private productService: ProductService) { }

  ngOnInit() {
  }

  onSubmitReserva(){
    //console.log(this.nFechas);
    //this.reserva.fechas.push(this.nFechas);
    this.productService.agregarReserva(this.reserva)
    .subscribe(result => {;
      alert('Reserva agregada exitosamente')
    },
    error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
  }
  
}
