import { Component } from '@angular/core';
import { ProductService } from './shared/services/product-service.service';
import { parseString } from 'xml2js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'EkoClient';
  id = '';

  constructor(private productService: ProductService) {}

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
}
