import { Injectable } from '@angular/core';
import { UtilsService } from '../../utils/utils.service';
import { HttpClient } from '@angular/common/http';
import { Calificacion } from '../../model/Calificacion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalificacionService {

  private calificacionURI: string = this.utils.baseUrl + 'productos/calificacion'

  constructor(
      private http: HttpClient,
      private utils: UtilsService
  ) { }

  public agregarCalificacion(nCalificacion: Calificacion): Observable<string> {
    let finalURI: string = this.calificacionURI;

    return this.http.post<string>(
      finalURI,
      nCalificacion,
      { withCredentials: true }
    )
  }

  public eliminarCalificacion(idProducto: string, idCalificacion: string): Observable<string> {
    let finalURI: string = this.calificacionURI;

    finalURI += '/' + idProducto + '/' + idCalificacion;

    return this.http.delete<string>(
      finalURI,
      { withCredentials: true }
    )
  }

  public obtenerCalificacion(idProducto: string, idCalificacion: string): Observable<Calificacion> {
    let finalURI: string = this.calificacionURI;

    finalURI += '/' + idProducto + '/' + idCalificacion;

    return this.http.get<Calificacion>(
      finalURI,
      { withCredentials: true }
    )
  }

  public actualizarCalificacion(nCalificacion: Calificacion): Observable<string> {
    let finalURI: string = this.calificacionURI;

    return this.http.put<string>(
      finalURI,
      nCalificacion,
      { withCredentials: true }
    )
  }

}
