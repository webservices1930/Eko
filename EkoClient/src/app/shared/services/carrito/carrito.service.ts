import { Injectable } from '@angular/core';
import { UtilsService } from '../../utils/utils.service';
import { HttpClient } from '@angular/common/http';
import { Carrito } from '../../model/Carrito/Carrito';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private carritoURI: string = this.utils.baseUrl + 'carrito';

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
    let finalURI: string = this.carritoURI;

    // Se realiza una petición POST
    return this.http.post<string>(
      finalURI,
      nCarrito,
      { withCredentials: true }
    );
  }


  /**
   * Busca el carrito de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string): Observable<Carrito> {
    let finalURI: string = this.carritoURI;

    finalURI += '/usuario/' + id;

    // Se realiza una petición POST
    return this.http.get<Carrito>(
      finalURI,
      { withCredentials: true }
    );
  }

  /**
   * Dado un Carrito realiza la petición SOAP necesaria
   * para actualizar un carrito al servidor
   *
   * @param nCarrito
   */
  public actualizarCarrito(nCarrito: Carrito): Observable<string> {
    let finalURI: string = this.carritoURI;

    // Se realiza una petición POST
    return this.http.put<string>(
      finalURI,
      nCarrito,
      { withCredentials: true }
    );
  }

  /**
   * Dado un Carrito realiza la petición SOAP necesaria
   * para eliminar un carrito delal servidor
   *
   * @param nCarrito
   */
  public eliminarCarrito(nCarrito: Carrito): Observable<any> {
    let finalURI: string = this.carritoURI;

    finalURI += '/usuario/' + nCarrito._id;

    // Se realiza una petición POST
    return this.http.delete<string>(
      finalURI,
      { withCredentials: true }
    );
  }

}
