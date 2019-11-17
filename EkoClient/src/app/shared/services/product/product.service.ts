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
import { Pregunta } from '../../model/Pregunta';
import { Calificacion } from '../../model/Calificacion';
import { Producto } from '../../model/Producto/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productosURI: string = this.utils.baseUrl + 'productos';

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
  public agregarProducto(nProducto: any): Observable<string> {
    let finalURI: string = this.productosURI;

    // Se establece la URI para hacer la petición
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        finalURI += '/transporte'
        break;
      case 'ALOJAMIENTO':
        finalURI += '/alojamiento'
        break;
      case 'EVENTO':
        finalURI += '/evento'
        break;
      case 'EXPERIENCIA':
        finalURI += '/experiencia'
        break;
      case 'SALIDA':
        finalURI += '/salida'
        break;
      case 'SITIO':
        finalURI += '/sitio'
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    // Se realiza una petición POST
    return this.http.post<string>(
      finalURI,
      nProducto,
      { withCredentials: true });
  }

  /**
   * Obtiene todos los productos del Market Place
   */
  public obtenerTodosLosProductos(): Observable<Producto[]> {
    // Se realiza una petición POST
    return this.http.get<Producto[]>(
      this.productosURI,
      { withCredentials: true }
    );
  }

  /**
   * Busca un producto de tipo Transporte por su ID en el Market Place
   * @param id
   */
  public buscarPorID(id: string): Observable<Producto> {
    let finalURI: string = this.productosURI;

    finalURI += '/' + id;

    // Se realiza una petición POST
    return this.http.get<Producto>(
      finalURI,
      { withCredentials: true }
    );
  }



  /**
   * Busca el listado de productos de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string): Observable<Producto[]> {
    let finalURI: string = this.productosURI;

    finalURI += '/usuario/' + id;

    // Se realiza una petición POST
    return this.http.get<Producto[]>(
      finalURI,
      { withCredentials: true }
    );
  }


  /**
  * Dado un Producto realiza la petición SOAP necesaria
  * para actualizar un producto al servidor
  *
  * @param nProducto
  */
  public actualizarProducto(nProducto: any): Observable<string> {
    let finalURI: string = this.productosURI;

    // Se establece la URI para hacer la petición
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        finalURI += '/transporte'
        break;
      case 'ALOJAMIENTO':
        finalURI += '/alojamiento'
        break;
      case 'EVENTO':
        finalURI += '/evento'
        break;
      case 'EXPERIENCIA':
        finalURI += '/experiencia'
        break;
      case 'SALIDA':
        finalURI += '/salida'
        break;
      case 'SITIO':
        finalURI += '/sitio'
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    // Se realiza una petición PUT
    return this.http.put<string>(
      finalURI,
      nProducto,
      { withCredentials: true });
  }

  /**
 * Dado un Producto realiza la petición SOAP necesaria
 * para eliminar un producto al servidor
 *
 * @param nProducto
 */
  public eliminarProducto(nProducto: any): Observable<string> {
    let finalURI: string = this.productosURI;

    // Se establece la URI para hacer la petición
    switch (nProducto['tipo']) {
      case 'TRANSPORTE':
        finalURI += '/transporte'
        break;
      case 'ALOJAMIENTO':
        finalURI += '/alojamiento'
        break;
      case 'EVENTO':
        finalURI += '/evento'
        break;
      case 'EXPERIENCIA':
        finalURI += '/experiencia'
        break;
      case 'SALIDA':
        finalURI += '/salida'
        break;
      case 'SITIO':
        finalURI += '/sitio'
        break;

      default:
        alert('Seleccione un tipo de producto');
        break;
    }

    finalURI += '/' + nProducto._id;

    // Se realiza una petición PUT
    return this.http.delete<string>(
      finalURI,
      { withCredentials: true });
  }

  public twitter(query: string){
    const finalURI = this.productosURI + '/twitter/' + query;
    return this.http.get(finalURI);
  }


}
