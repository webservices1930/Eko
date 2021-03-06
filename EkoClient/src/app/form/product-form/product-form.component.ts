import { Component, OnInit, NgModule } from '@angular/core';
import { Transporte } from '../../shared/model/Producto/Transporte';
import { Disponibilidad } from '../../shared/model/Disponibilidad';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router } from '@angular/router';
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
import { WeatherService } from 'src/app/shared/weather/weather.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {
  public tiposProducto: string[];
  public tiposProductoEspecifico: string[];
  public listaDisponibilidad: Disponibilidad[] = [new Disponibilidad()];
  public producto: any | Producto;
  public listaTrayecto: any[] = [{ valor: '' }];

  public precio: string = '';
  public infoPaisDestino: string = '';
  public descripcion: string = '';
  public tipo: string = '';
  public titulo: string = '';
  public foto: string = '';
  public ciudad: string = '';

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router,
    private weatherService: WeatherService
  ) {
    this.tiposProducto = this.utils.valoresDeEnum(TipoProducto);
  }

  ngOnInit() { }

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
    this.producto._id = '';
    this.producto.precio = this.precio;
    this.producto.infoPaisDestino = this.infoPaisDestino;
    this.producto.disponibilidad = this.listaDisponibilidad;
    this.producto.descripcion = this.descripcion;
    this.producto.tipo = this.tipo;
    this.producto.idUsuario = this.userService.obtenerCorreoUsuario();
    this.producto.titulo = this.titulo;
    this.producto.foto = this.foto;
    this.producto.ciudad = this.ciudad;

    if (this.tipo === 'TRANSPORTE' || this.tipo === 'SALIDA') {
      this.listaTrayecto.forEach(trayecto => {
        this.producto.trayecto.push(trayecto.valor);
      });
    }

    console.log(this.producto);

    this.productService.agregarProducto(this.producto)
      .subscribe(result => {
        alert('Producto agregado exitosamente');
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  public llenarLatitudYLongitud() {
    this.weatherService.obtenerInformacionClimaPorNombreCiudad(this.ciudad)
      .subscribe(infoCiudadResponse => {
        this.producto.latitud = infoCiudadResponse.coord.lat;
        this.producto.longitud = infoCiudadResponse.coord.lon;
      }, error => {
        alert('No se encontró latitud y longitud para la ciudad dada');
      })
  }
}
