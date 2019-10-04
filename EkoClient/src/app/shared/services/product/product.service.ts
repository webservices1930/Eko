import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Transporte } from '../../model/Producto/Transporte';
import { Observable } from 'rxjs';

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
   * @param nTransporte 
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
        <obtenerTodosLosProductos xmlns="http://iservice.eko.javeriana.edu.co/"/>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/market-place?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Busca un producto de tipo Transporte por su ID en el Market Place
   * @param id
   */
  public buscarPorID(id: string) {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <buscarProductoTransportePorID xmlns="http://iservice.eko.javeriana.edu.co/">
          <transporteID xmlns="">` + id + `</transporteID>
        </buscarProductoTransportePorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/productos?wsdl',
      body,
      httpOptions
    );
  }
}