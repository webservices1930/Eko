import {Injectable} from '@angular/core';
import {UtilsService} from '../../utils/utils.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Catalogo} from '../../model/Catalogo/catalogo';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) {
  }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para agregar un producto al servidor
   *
   * @param nCatalogo
   */
  public agregarCatalogo(nCatalogo: Catalogo): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();
    let productos = '';

    nCatalogo.productos.forEach(prod => {
      productos += `<productos>` + prod + `</productos>`;
    });

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <agregarCatalogo xmlns="http://iservice.eko.javeriana.edu.co/">
          <nCatalogo xmlns="">
            <descripcion>` + nCatalogo.descripcion + `</descripcion>
            <idUsuario>` + nCatalogo.idUsuario + `</idUsuario>
            <nombre>` + nCatalogo.nombre + `</nombre>
            <precio>` + nCatalogo.precio + `</precio>
            `
      + productos +
      `
            <_id>` + nCatalogo + `</_id>
          </nCatalogo>
        </agregarCatalogo>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Obtiene todos los catalogos del Market Place
   */
  public obtenerTodosLosCatalogos(): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <obtenerCatalogos xmlns="http://iservice.eko.javeriana.edu.co/"/>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Busca un catalogo de tipo Transporte por su ID en el Market Place
   * @param id
   */
  public buscarPorID(id: string) {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <buscarCatalogoPorID xmlns="http://iservice.eko.javeriana.edu.co/">
          <catalogoID xmlns="">` + id + `</catalogoID>
        </buscarCatalogoPorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }


  /**
   * Busca el listado de catalogos de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string) {
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <obtenerCatalogosPorUsuario xmlns="http://iservice.eko.javeriana.edu.co/">
          <usuarioID xmlns="">` + id + `</usuarioID>
        </obtenerCatalogosPorUsuario>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para actualizar un catalogo al servidor
   *
   * @param nCatalogo
   */
  public actualizarCatalogo(nCatalogo: Catalogo): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();
    let productos = '';

    nCatalogo.productos.forEach(prod => {
      productos += `<productos>` + prod + `</productos>`;
    });

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <actualizarCatalogo xmlns="http://iservice.eko.javeriana.edu.co/">
          <catalogo xmlns="">
            <descripcion>` + nCatalogo.descripcion + `</descripcion>
            <idUsuario>` + nCatalogo.idUsuario + `</idUsuario>
            <nombre>` + nCatalogo.nombre + `</nombre>
            <precio>` + nCatalogo.precio + `</precio>
            `
      + productos +
      `
            <_id>` + nCatalogo + `</_id>
          </catalogo>
        </actualizarCatalogo>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para eliminar un catalogo al servidor
   *
   * @param nCatalogo
   */
  public eliminarCatalogo(nCatalogo: Catalogo): Observable<any> {
    // Se especifíca que la petición se hará por XML
    const httpOptions: object = this.utils.crearHeadersXML();

    // Se crea la establece la información que se enviará al servidor
    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
      <eliminarCatalogoPorID xmlns="http://iservice.eko.javeriana.edu.co/">
        <catalogoID xmlns="">` + nCatalogo._id + `</catalogoID>
      </eliminarCatalogoPorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      body,
      httpOptions
    );
  }

}
