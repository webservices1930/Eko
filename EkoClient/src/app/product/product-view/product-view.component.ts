import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { CarritoService } from 'src/app/shared/services/carrito/carrito.service';
import { Carrito } from 'src/app/shared/model/Carrito/Carrito';
import { UserService } from 'src/app/shared/services/user/user.service';
import { WeatherService } from 'src/app/shared/weather/weather.service';


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
  public mostrarEnMapa: boolean = false;
  public trayectos: any[] = [{ origen: undefined, destino: undefined }];
  public tieneTrayecto: boolean = false;
  public tieneInfoCiudad: boolean = false;
  public infoCiudad: any = undefined;
  public calificacion = 5;
  public calificaciones:any = [];

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router,
    private carritoService: CarritoService,
    private route: ActivatedRoute,
    private weatherService: WeatherService
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

        if (this.producto.longitud !== undefined && this.producto.latitud !== undefined) {
          this.mostrarEnMapa = true;
        } else {
          this.mostrarEnMapa = false;
        }

        if (this.producto.trayecto !== undefined) {
          this.tieneTrayecto = true;
        } else {
          this.tieneTrayecto = false;
        }

        this.weatherService.obtenerInformacionClimaPorNombreCiudad(this.producto.ciudad)
          .subscribe(climaResponse => {
            this.weatherService.obtenerInformacionCapital(climaResponse.sys.country)
              .subscribe(capitalResponse => {
                this.infoCiudad = {
                  pais: capitalResponse.name,
                  code: capitalResponse.alpha2Code,
                  bandera: capitalResponse.flag
                };

                this.tieneInfoCiudad = true;
              });
          })


        if (this.tieneTrayecto && this.producto.tipo === 'TRANSPORTE') {
          for (let lugar of this.producto.trayecto) {
            this.weatherService.obtenerInformacionClimaPorNombreCiudad(lugar).subscribe(result => {
              if (this.trayectos[this.trayectos.length - 1].origen === undefined) {
                this.trayectos[this.trayectos.length - 1].origen = {
                  lat: result.coord.lat,
                  lng: result.coord.lon
                };
              } else if (this.trayectos[this.trayectos.length - 1].destino === undefined) {
                this.trayectos[this.trayectos.length - 1].destino = {
                  lat: result.coord.lat,
                  lng: result.coord.lon
                };
                this.trayectos.push({ origen: undefined, destino: undefined });
              }
            });
          }
          console.log(this.trayectos)
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
