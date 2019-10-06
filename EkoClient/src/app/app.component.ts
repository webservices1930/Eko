import { Component } from '@angular/core';
import { ProductService } from './shared/services/product-service.service';
import { parseString } from 'xml2js';
import { ReservaService } from './shared/services/reserva-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'EkoClient';
  id = '';
  idreservas='';

  constructor(private productService: ProductService,private reservaService: ReservaService) {}

  /**
   * Llama al servicio para obtener todos los productos del MarketPlace en XML
   * 
   * @param event 
   */
  public obetenerTodosLosProductos(event: Event) {
    event.preventDefault();
    this.productService.obtenerTodosLosProductos()
    .subscribe(result => {
      // console.log(result);
      parseString(result, function (err, res) {
        console.log(res['S:Envelope']['S:Body'][0]['ns2:obtenerTodosLosProductosResponse'][0]['marketPlace']);
      });
    },
    error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
  }

  public buscarPorID() {
    this.productService.buscarPorID(this.id)
    .subscribe(result => {
      // console.log(result);
      parseString(result, function (err, res) {
        console.log(res);
      });
    },
    error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
  }

  public obtenerReservasCliente(){
    this.reservaService.buscarPorID(this.idreservas)
    .subscribe(result=>{
      parseString(result, function (err, res) {
        console.log(res);
        alert("Reservas de un cliente encontradas con exito");
      });
    },
    error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
    console.log(this.idreservas);
  }
}
