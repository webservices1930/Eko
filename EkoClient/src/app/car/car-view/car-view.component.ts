import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/shared/services/user/user.service';
import { CarritoService } from 'src/app/shared/services/carrito/carrito.service';
import { Carrito } from 'src/app/shared/model/Carrito/carrito';

@Component({
  selector: 'app-car-view',
  templateUrl: './car-view.component.html',
  styleUrls: ['./car-view.component.scss']
})
export class CarViewComponent implements OnInit {
  public carrito: Carrito;
  public hayCarrito: boolean = false;
  public productos: any[];

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router,
    private carritoService: CarritoService,
    private route: ActivatedRoute
  ) {
    this.carritoService.buscarPorIDUsuario(this.userService.obtenerCorreoUsuario())
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        let carrito = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:obtenerCarritoPorUsuarioResponse'][0]['listaCarritoUsuario'][0];
        this.hayCarrito = true;

        for (let producto of carrito.productos) {
          this.productService.buscarPorID(producto)
            .subscribe(result => {
              const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
              let nProducto = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];
              console.log(nProducto)
              // this.productos.push(nProducto);
            }, error => {
              console.log('There was an error: ', error);
              console.log(error.status);
            });
        }
      }, error => {
        let carrito = new Carrito();
        this.hayCarrito = false;
      });
  }

  ngOnInit() {
  }

}
