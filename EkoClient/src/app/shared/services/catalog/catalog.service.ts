import { Injectable } from '@angular/core';
import { UtilsService } from '../../utils/utils.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Catalogo } from '../../model/Catalogo/catalogo';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

   /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para agregar un producto al servidor
   *
   * @param nCatalogo
   */
  public agregarCatalogo(nCatalogo: Catalogo): Observable<any> {
    // Se especifíca que la petición se hará por XML

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }

  /**
   * Obtiene todos los catalogos del Market Place
   */
  public obtenerTodosLosCatalogos(): Observable<any> {
    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }

   /**
   * Busca un catalogo de tipo Transporte por su ID en el Market Place
   * @param id
   */
  public buscarPorID(id: string) {
    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }


  /**
   * Busca el listado de catalogos de un Usuario
   * @param id
   */
  public buscarPorIDUsuario(id: string) {
    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para actualizar un catalogo al servidor
   *
   * @param nCatalogo
   */
  public actualizarCatalogo(nCatalogo: Catalogo): Observable<any> {
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }

  /**
   * Dado un Producto realiza la petición SOAP necesaria
   * para eliminar un catalogo al servidor
   *
   * @param nCatalogo
   */
  public eliminarCatalogo(nCatalogo: Catalogo): Observable<any> {
    return this.http.post(
      this.utils.baseUrl + 'eko/catalogo?wsdl',
      { withCredentials: true }
    );
  }

}
