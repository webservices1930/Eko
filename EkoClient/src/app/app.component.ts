import { Component } from '@angular/core';
import { ProductService } from './shared/services/product-service.service';
import { parseString, parser } from 'xml2js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'EkoClient';

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
      console.log(result);
    },
    error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
  }

  public parseXML(data) {
    return new Promise(resolve => {
      var k: string | number,
        arr = [],
        parser = new parser();
        console.log(parser)
      //   parser.parser(
      //     {
      //       trim: true,
      //       explicitArray: true
      //     });
      // parser.parseString(data, function(err, result) {
      //   console.log(result);
      //   console.log(err);
      // });
    });
  }
}
