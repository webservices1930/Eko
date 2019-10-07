import { Component, OnInit } from '@angular/core';
import { ProductService } from '../shared/services/product/product.service';
import { UtilsService } from '../shared/utils/utils.service';
import { UserService } from '../shared/services/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-market-place',
  templateUrl: './market-place.component.html',
  styleUrls: ['./market-place.component.scss']
})
export class MarketPlaceComponent implements OnInit {
  public productos: any[];

  constructor(private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router
    ) {
      this.productService.obtenerTodosLosProductos()
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        this.productos = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:obtenerProductosResponse'][0]['listadoProductos'];
        console.log(this.productos);
      }, error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });
    }

  ngOnInit() {
  }

}
