import { Component, OnInit } from '@angular/core';
import { ProductService } from './shared/services/product/product.service';
import { parseString } from 'xml2js';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'EkoClient';
  id = '';

  constructor(
    private cookieService: CookieService,
    private router: Router
  ) {}

  ngOnInit() {
    if (this.cookieService.get('login') === 'logged') {
      this.router.navigateByUrl('');
    } else {
      this.router.navigateByUrl('user/login');
    }
  }

  /**
   * Llama al servicio para obtener todos los productos del MarketPlace en XML
   * 
   * @param event 
   */
  // public obetenerTodosLosProductos(event: Event) {
  //   event.preventDefault();
  //   this.productService.obtenerTodosLosProductos()
  //   .subscribe(result => {
  //     // console.log(result);
  //     parseString(result, function (err, res) {
  //       console.log(res['S:Envelope']['S:Body'][0]['ns2:obtenerTodosLosProductosResponse'][0]['marketPlace']);
  //     });
  //   },
  //   error =>{
  //     console.log('There was an error: ', error);
  //     console.log(error.status);
  //   });
  // }

  // public buscarPorID() {
  //   this.productService.buscarPorID(this.id)
  //   .subscribe(result => {
  //     // console.log(result);
  //     parseString(result, function (err, res) {
  //       console.log(res);
  //     });
  //   },
  //   error =>{
  //     console.log('There was an error: ', error);
  //     console.log(error.status);
  //   });
  // }
}
