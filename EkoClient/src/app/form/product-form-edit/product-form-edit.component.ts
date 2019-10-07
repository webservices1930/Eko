import { Component, OnInit, NgModule } from '@angular/core';
import { Transporte } from '../../shared/model/Producto/Transporte';
import { Disponibilidad } from '../../shared/model/Disponibilidad';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TipoProducto } from 'src/app/shared/model/TipoProducto';
import { Producto } from 'src/app/shared/model/Producto/Producto';
import { FormsModule } from '@angular/forms';
import { Alojamiento } from 'src/app/shared/model/Producto/Alojamiento';
import { Evento } from 'src/app/shared/model/Producto/Evento';
import { Experiencia } from 'src/app/shared/model/Producto/Experiencia';
import { Salida } from 'src/app/shared/model/Producto/Salida';
import { Sitio } from 'src/app/shared/model/Producto/Sitio';
import { TipoTransporte } from 'src/app/shared/model/TipoTransporte';
import { UserService } from 'src/app/shared/services/user/user.service';
import { TipoAlojamiento } from 'src/app/shared/model/TipoAlojamiento';
import { TipoDeEvento } from 'src/app/shared/model/TipoDeEvento';
import { TipoExperiencia } from 'src/app/shared/model/TipoExperiencia';
import { TipoSalida } from 'src/app/shared/model/TipoSalida';
import { TipoDeSitio } from 'src/app/shared/model/TipoDeSitio';

@Component({
  selector: 'app-product-form-edit',
  templateUrl: './product-form-edit.component.html',
  styleUrls: ['./product-form-edit.component.scss']
})
export class ProductFormEditComponent implements OnInit {
  public tiposProducto: string[];
  public tiposProductoEspecifico: string[];
  public listaDisponibilidad: Disponibilidad[] = [new Disponibilidad()];
  public producto: any | Producto;
  public listaTrayecto: any[] = [{ valor: '' }];

  public id: string = '';
  public precio: string = '';
  public infoPaisDestino: string = '';
  public descripcion: string = '';
  public tipo: string = '';

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.tiposProducto = this.utils.valoresDeEnum(TipoProducto);

  }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.productService.buscarPorID(this.id)
      .subscribe(prod => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(prod as string);
        this.producto = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];
        console.log(this.producto);
        this.descripcion = this.producto.descripcion;
        this.listaDisponibilidad = this.producto.disponibilidad;
        this.infoPaisDestino = this.producto.infoPaisDestino;
        this.precio = this.producto.precio;
        this.tipo = this.producto.tipo[0];
        this.seleccionarTipo();
        this.productService.buscarPorID(this.id)
          .subscribe(prod2 => {
            const infoRespuesta2 = this.utils.convertirXMLEnObjeto(prod2 as string);
            this.producto = infoRespuesta2['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];
            switch(this.tipo){
              case'ALOJAMIENTO':
              this.producto.tipoAlojamiento = this.producto.tipoAlojamiento[0];
                break;
              case 'SITIO':
                this.producto.tipoDeSitio = this.producto.tipoDeSitio[0];
                break;
              case 'TRANSPORTE':
                this.producto.tipoTransporte = this.producto.tipoTransporte[0];
                break;

              case 'EVENTO':
                this.producto.tipoEvento = this.producto.tipoEvento[0];
                break;
              case 'SALIDA':
                  this.producto.tipoSalida = this.producto.tipoSalida[0];
                break;
              case 'EXPERIENCIA':
                this.producto.tipoExperiencia = this.producto.tipoExperiencia[0];
                break;

            }
            console.log(this.producto.tipoSalida);
          });
      });

  }


  /**
   * Agrega una nueva disponibilidad al formulario
   */
  public agregarDisponibilidad() {
    this.listaDisponibilidad.push(new Disponibilidad());
  }

  /**
   * Elimina una disponibilidad del formulario
   */
  public eliminarDisponibilidad() {
    const tamano: number = this.listaDisponibilidad.length;
    if (tamano > 1) {
      this.listaDisponibilidad.splice((tamano - 1), 1);
    }
  }

  /**
   * Agrega un trayecto
   * @param nombreArreglo
   */
  public agregarTrayecto() {
    this.listaTrayecto.push({ valor: '' });
  }

  /**
   * Elimina un trayecto
   */
  public eliminarTrayecto() {
    const tamano: number = this.listaTrayecto.length;
    if (tamano > 1) {
      this.listaTrayecto.splice((tamano - 1), 1);
    }
  }

  /**
   * Actualiza el tipo de Producto y crea un objeto del tipo seleccionado
   */
  public seleccionarTipo() {
    switch (this.tipo) {
      case 'ALOJAMIENTO':
        this.producto = new Alojamiento();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoAlojamiento);
        break;
      case 'EVENTO':
        this.producto = new Evento();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoDeEvento);
        break;
      case 'EXPERIENCIA':
        this.producto = new Experiencia();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoExperiencia);
        break;
      case 'SALIDA':
        this.producto = new Salida();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoSalida);
        break;
      case 'SITIO':
        this.producto = new Sitio();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoDeSitio);
        break;
      case 'TRANSPORTE':
        this.producto = new Transporte();
        this.tiposProductoEspecifico = this.utils.valoresDeEnum(TipoTransporte);
        break;
      default:
        break;
    }
  }

  public onSubmit() {
    this.producto._id = this.id;
    this.producto.precio = this.precio;
    this.producto.infoPaisDestino = this.infoPaisDestino;
    this.producto.disponibilidad = this.listaDisponibilidad;
    this.producto.descripcion = this.descripcion;
    this.producto.tipo = this.tipo;
    this.producto.idUsuario = this.userService.obtenerCorreoUsuario();

    if (this.tipo === 'TRANSPORTE' || this.tipo === 'SALIDA' ) {
      console.log('Trayecto');
      this.producto.trayecto = [];
      this.listaTrayecto.forEach(trayecto => {
        this.producto.trayecto.push(trayecto.valor);
      });
    }
    console.log(this.tipo);
    console.log(this.producto);

    this.productService.actualizarProducto(this.producto)
      .subscribe(result => {
        alert('Producto actualizado exitosamente');
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  public eliminar(){
    this.producto._id = this.id;
    this.producto.precio = this.precio;
    this.producto.infoPaisDestino = this.infoPaisDestino;
    this.producto.disponibilidad = this.listaDisponibilidad;
    this.producto.descripcion = this.descripcion;
    this.producto.tipo = this.tipo;
    this.producto.idUsuario = this.userService.obtenerCorreoUsuario();

    if (this.tipo === 'TRANSPORTE' || this.tipo === 'SALIDA' ) {
      console.log('Trayecto');
      this.producto.trayecto = [];
      this.listaTrayecto.forEach(trayecto => {
        this.producto.trayecto.push(trayecto.valor);
      });
    }

    console.log(this.producto);
    this.productService.eliminarProducto(this.producto)
      .subscribe(result =>{
        alert('Producto eliminado exitosamente');
      }, error => {
        console.log('There was an error', error);
        console.log(error.status);
      });
  }

}
