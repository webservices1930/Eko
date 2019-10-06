import { Injectable } from '@angular/core';
import { UtilsService } from '../../utils/utils.service';
import { HttpClient } from '@angular/common/http';
import { Carrito } from '../../model/Carrito/carrito';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

   /**
   * Dado un Carrito realiza la petición SOAP necesaria
   * para agregar un carrito al servidor
   *
   * @param nCarrito
   */
  public agregarCarrito(nCarrito: Carrito): Observable<any> {

    const httpOptions: object = this.utils.crearHeadersXML();
    let productos = '';

    nCarrito.productos.forEach(prod => {
      productos += `<productos>` + prod + `</productos>`;
    });

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <agregarCarrito xmlns="http://iservice.eko.javeriana.edu.co/">
          <carrito xmlns="">
              <idUsuario>` + nCarrito.idUsuario + `</idUsuario>
              `
              + productos +
              `
          </carrito>
        </agregarCarrito>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/carrito?wsdl',
      body,
      httpOptions
    );
  }


  /**
   * Busca el carrito de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string) {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <obtenerCarritoPorUsuario xmlns="http://iservice.eko.javeriana.edu.co/">
          <usuarioID xmlns="">` + id + `</usuarioID>
        </obtenerCarritoPorUsuario>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/carrito?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Dado un Carrito realiza la petición SOAP necesaria
   * para actualizar un carrito al servidor
   *
   * @param nCarrito
   */
  public actualizarCarrito(nCarrito: Carrito): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();
    let productos = '';

    nCarrito.productos.forEach(prod => {
      productos += `<productos>` + prod + `</productos>`;
    });

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <actualizarCarrito xmlns="http://iservice.eko.javeriana.edu.co/">
          <carrito xmlns="">
              <idUsuario>` + nCarrito.idUsuario + `</idUsuario>
              `
              + productos +
              `
              <_id>` + nCarrito._id + `</_id>
          </carrito>
        </actualizarCarrito>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/carrito?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Dado un Carrito realiza la petición SOAP necesaria
   * para eliminar un carrito delal servidor
   *
   * @param nCarrito
   */
  public eliminarCarrito(nCarrito: Carrito): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <eliminarCarritoPorID xmlns="http://iservice.eko.javeriana.edu.co/">
            <carritoID xmlns="">` + nCarrito._id + `</carritoID>
        </eliminarCarritoPorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/carrito?wsdl',
      body,
      httpOptions
    );
  }

}
