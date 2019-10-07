import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Transporte } from '../../model/Producto/Transporte';
import { Observable } from 'rxjs';
import { Alojamiento } from '../../model/Producto/Alojamiento';
import { Evento } from '../../model/Producto/Evento';
import { Experiencia } from '../../model/Producto/Experiencia';
import { Salida } from '../../model/Producto/Salida';
import { Sitio } from '../../model/Producto/Sitio';
import { Reserva } from '../../model/Reserva';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para agregar un producto al servidor
   *
   * @param nProducto
   */
  public agregarProducto(nProducto: any): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    let accionXML: string = '';

    // Se crea el cuerpo de la petición dependiendo del tipo de producto
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        accionXML = `
          <agregarProductoTransporte xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearTransporteXML(nProducto as Transporte) +
          `</agregarProductoTransporte>`;
        break;
      case 'ALOJAMIENTO':
        accionXML = `
          <agregarProductoAlojamiento xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearAlojamientoXML(nProducto as Alojamiento) +
          `</agregarProductoAlojamiento>`;
        break;
      case 'EVENTO':
        accionXML = `
          <agregarProductoEvento xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearEventoXML(nProducto as Evento) +
          `</agregarProductoEvento>`;
        break;
      case 'EXPERIENCIA':
        accionXML = `
          <agregarProductoExperiencia xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearExperienciaXML(nProducto as Experiencia) +
          `</agregarProductoExperiencia>`;
        break;

      case 'SALIDA':
        accionXML = `
          <agregarProductoSalida xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearSalidaXML(nProducto as Salida) +
          `</agregarProductoSalida>`;
        break;
      case 'SITIO':
        accionXML = `
          <agregarProductoSitio xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearSitioXML(nProducto as Sitio) +
          `</agregarProductoSitio>`;
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>`
      + accionXML +
      `</Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Obtiene todos los productos del Market Place
   */
  public obtenerTodosLosProductos(): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <obtenerProductos xmlns="http://iservice.eko.javeriana.edu.co/"/>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Busca un producto de tipo Transporte por su ID en el Market Place
   * @param id
   */
  public buscarPorID(id: string): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <buscarProductoPorId xmlns="http://iservice.eko.javeriana.edu.co/">
          <productoID xmlns="">` + id + `</productoID>
        </buscarProductoPorId>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }



  /**
   * Busca el listado de productos de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string) {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <obtenerProductosPorUsuario xmlns="http://iservice.eko.javeriana.edu.co/">
          <usuarioID xmlns="">` + id + `</usuarioID>
        </obtenerProductosPorUsuario>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }


   /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para actualizar un producto al servidor
   *
   * @param nProducto
   */
  public actualizarProducto(nProducto: any): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    let accionXML: string = '';

    // Se crea el cuerpo de la petición dependiendo del tipo de producto
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        accionXML = `
          <actualizarProductoTransporte xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearTransporteXML(nProducto as Transporte) +
          `</actualizarProductoTransporte>`;
        break;
      case 'ALOJAMIENTO':
        accionXML = `
          <actualizarProductoAlojamiento xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearAlojamientoXML(nProducto as Alojamiento) +
          `</actualizarProductoAlojamiento>`;
        break;
      case 'EVENTO':
        accionXML = `
          <actualizarProductoEvento xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearEventoXML(nProducto as Evento) +
          `</actualizarProductoEvento>`;
        break;
      case 'EXPERIENCIA':
        accionXML = `
          <actualizarProductoExperiencia xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearExperienciaXML(nProducto as Experiencia) +
          `</actualizarProductoExperiencia>`;
        break;

      case 'SALIDA':
        accionXML = `
          <actualizarProductoSalida xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearSalidaXML(nProducto as Salida) +
          `</actualizarProductoSalida>`;
        break;
      case 'SITIO':
        accionXML = `
          <actualizarProductoSitio xmlns="http://iservice.eko.javeriana.edu.co/">`
          + this.utils.crearSitioXML(nProducto as Sitio) +
          `</actualizarProductoSitio>`;
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>`
      + accionXML +
      `</Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

    /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para eliminar un producto al servidor
   *
   * @param nProducto
   */
  public eliminarProducto(nProducto: any): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    let accionXML: string = '';

    console.log(nProducto)

    // Se crea el cuerpo de la petición dependiendo del tipo de producto
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        accionXML = `
          <eliminarProductoTransporte xmlns="http://iservice.eko.javeriana.edu.co/">
            <transporteID xmlns="">` + nProducto._id + `</transporteID>
          </eliminarProductoTransporte>`;
        break;
      case 'ALOJAMIENTO':
        accionXML = `
          <eliminarProductoAlojamiento xmlns="http://iservice.eko.javeriana.edu.co/">
           <alojamientoID xmlns="">` + nProducto._id + `</alojamientoID>
          </eliminarProductoAlojamiento>`;
        break;
      case 'EVENTO':
        accionXML = `
          <eliminarProductoEvento xmlns="http://iservice.eko.javeriana.edu.co/">
           <eventoID xmlns="">` + nProducto._id + `</eventoID>
          </eliminarProductoEvento>`;
        break;
      case 'EXPERIENCIA':
        accionXML = `
          <eliminarProductoExperiencia xmlns="http://iservice.eko.javeriana.edu.co/">
           <experienciaID xmlns="">` + nProducto._id + `</experienciaID>
          </eliminarProductoExperiencia>`;
        break;

      case 'SALIDA':
        accionXML = `
          <eliminarProductoSalida xmlns="http://iservice.eko.javeriana.edu.co/">
            <salidaID xmlns="">` + nProducto._id + `</salidaID>
          </eliminarProductoSalida>`;
        break;
      case 'SITIO':
        accionXML = `
          <eliminarProductoSitio xmlns="http://iservice.eko.javeriana.edu.co/">
            <sitioID  xmlns="">` + nProducto._id + `</sitioID>
          </eliminarProductoSitio>`;
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>`
      + accionXML +
      `</Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

 /**
   * Dado una reserva realiza la petición SOAP necesaria
   * para agregar una reserva al servidor
   */
  public agregarReserva(nReserva: any): Observable<any>{
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    let accionXML: string = '';

    // Se crea el cuerpo de la petición dependiendo del tipo de producto
    accionXML = `
      <agregarReserva xmlns="http://iservice.eko.javeriana.edu.co/">`
        + this.utils.crearReservaXML(nReserva as Reserva) +
      `</agregarReserva>`;

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>`
      + accionXML +
      `</Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

  public buscarReservaPorUsuario(id: string): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <buscarReservasClientePorID xmlns="http://iservice.eko.javeriana.edu.co/">
          <clienteID xmlns="">` + id + `</clienteID>
        </buscarReservasClientePorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }

  public eliminarReserva(id: string): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <eliminarReservaPorID xmlns="http://iservice.eko.javeriana.edu.co/">
          <reservaID xmlns="">` + id + `</reservaID>
        </eliminarReservaPorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/producto?wsdl',
      body,
      httpOptions
    );
  }
}
