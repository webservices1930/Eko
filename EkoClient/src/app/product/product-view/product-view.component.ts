import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { CarritoService } from 'src/app/shared/services/carrito/carrito.service';
import { Carrito } from 'src/app/shared/model/Carrito/Carrito';
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
  public esMiProducto: boolean = false;

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
      .subscribe(productoResponse => {
        this.producto = productoResponse;
        this.productoCargado = true;

        if (this.producto.idUsuario === this.userService.obtenerCorreoUsuario()) {
          this.esMiProducto = true;
        }
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
      .subscribe(carritoResponse => {
        console.log(carritoResponse)
        let carrito = carritoResponse;

        carrito.productos.push(this.id);
        this.carritoService.actualizarCarrito(carrito)
          .subscribe(result => {
            alert('Se ha agregado exitosamente al carrito');
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
            alert('Se ha agregado exitosamente al carrito');
          }, error => {
            console.log('There was an error: ', error);
            console.log(error.status);
          });
      });
  }
}
