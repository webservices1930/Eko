import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/shared/services/user/user.service';
import { CarritoService } from 'src/app/shared/services/carrito/carrito.service';
import { Carrito } from 'src/app/shared/model/Carrito/carrito';
import { Reserva } from 'src/app/shared/model/Reserva';

@Component({
  selector: 'app-car-view',
  templateUrl: './car-view.component.html',
  styleUrls: ['./car-view.component.scss']
})
export class CarViewComponent implements OnInit {
  public carrito: Carrito;
  public hayCarrito: boolean = false;
  public hayReservas: boolean = false;
  public productos: any[] = [];
  public reservas: any[] = [];

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
        this.carrito = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:obtenerCarritoPorUsuarioResponse'][0]['listaCarritoUsuario'][0];
        this.hayCarrito = true;

        for (let producto of this.carrito.productos) {
          this.productService.buscarPorID(producto)
            .subscribe(result => {
              const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
              let nProducto = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];

              if (nProducto.tipo !== undefined) {

                nProducto.verInfoProducto = false;
                nProducto.reservas = [];

                for (let disponibilidad of nProducto.disponibilidad) {
                  disponibilidad.reserva = {};
                }

                this.productos.push(nProducto);
              } else {
                this.eliminarDelCarrito(producto);
              }
            }, error => {
              console.log('There was an error: ', error);
              console.log(error.status);
            });
        }

        this.productService.buscarReservaPorUsuario(this.userService.obtenerCorreoUsuario())
          .subscribe(result => {
            const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
            this.reservas = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarReservasClientePorIDResponse'][0]['reservasCliente'];
            this.hayReservas = true;
          }, error => {
            this.hayReservas = false;
            console.log('There was an error: ', error);
            console.log(error.status);
          });
      }, error => {
        let carrito = new Carrito();
        this.hayCarrito = false;
      });
  }

  ngOnInit() {
  }

  public eliminarDelCarrito(productoID: string) {
    let fueEliminado: boolean = false;

    this.carrito.productos.forEach((producto, index) => {
      if (productoID == producto && !fueEliminado) {
        fueEliminado = true;
        this.carrito.productos.splice(index, 1);

        this.carritoService.actualizarCarrito(this.carrito)
          .subscribe(result => {
            alert('Producto eliminado del carrito con éxito')
            window.location.reload();
          }, error => {
            console.log('There was an error: ', error);
            console.log(error.status);
          })
      }
    });


  }

  public abrirInfoReserva(producto: any) {
    producto.verInfoProducto = !producto.verInfoProducto;
  }

  public reservarProducto(producto: any, disponibilidad: any) {
    let nReserva: Reserva = new Reserva();
    nReserva.clienteid = this.userService.obtenerCorreoUsuario();
    nReserva.fechas = disponibilidad.fecha;
    nReserva.productoid = producto._id;

    this.productService.agregarReserva(nReserva)
      .subscribe(result => {
        alert('Reserva realizada')
        window.location.reload();
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  public eliminarReserva(reserva: any) {
    this.productService.eliminarReserva(reserva._id)
      .subscribe(result => {
        alert('Reserva eliminada con éxito');
        window.location.reload();
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      })
  }

}
