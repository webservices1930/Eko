import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { CarritoService } from 'src/app/shared/services/carrito/carrito.service';
import { Carrito } from 'src/app/shared/model/Carrito/carrito';
import { UserService } from 'src/app/shared/services/user/user.service';


@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.scss']
})
export class ProductViewComponent implements OnInit {
  public producto: any;
  public tipo: string = '';
  public id: string = '';
  public productoCargado: boolean = false;

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router,
    private carritoService: CarritoService,
    private route: ActivatedRoute
  ) {
    this.tipo = this.route.snapshot.paramMap.get('tipo');
    this.id = this.route.snapshot.paramMap.get('id');
    this.productService.buscarPorID(this.id)
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result as string);
        this.producto = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];
        this.productoCargado = true;
        console.log(this.producto)
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  ngOnInit() {
  }

  /**
   * Agrega productos al carrito
   */
  public agregarAlCarrito() {
    this.carritoService.buscarPorIDUsuario(this.userService.obtenerCorreoUsuario())
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        let carrito = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:obtenerCarritoPorUsuarioResponse'][0]['listaCarritoUsuario'][0];
        carrito.productos.push(this.id);
        this.carritoService.actualizarCarrito(carrito)
          .subscribe(result => {
            const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
          }, error => {
            console.log('There was an error: ', error);
            console.log(error.status);
          });
      }, error => {
        let carrito = new Carrito();
        carrito.idUsuario = this.userService.obtenerCorreoUsuario();
        carrito.productos.push(this.id);
        this.carritoService.agregarCarrito(carrito)
          .subscribe(result => {
            const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
          }, error => {
            console.log('There was an error: ', error);
            console.log(error.status);
          });
      });
  }
}