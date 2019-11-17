import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Pregunta } from '../../model/Pregunta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreguntaService {

  private preguntaURI: string = this.utils.baseUrl + 'productos/pregunta'

  constructor(
      private http: HttpClient,
      private utils: UtilsService
  ) { }

  public agregarPregunta(nPregunta: Pregunta): Observable<string> {
    let finalURI: string = this.preguntaURI;

    return this.http.post<string>(
      finalURI,
      nPregunta,
      { withCredentials: true }
    )
  }

  public eliminarPregunta(idProducto: string, idCalificacion: string): Observable<string> {
    let finalURI: string = this.preguntaURI;

    finalURI += '/' + idProducto + '/' + idCalificacion;

    return this.http.delete<string>(
      finalURI,
      { withCredentials: true }
    )
  }

  public obtenerPregunta(idProducto: string, idCalificacion: string): Observable<string> {
    let finalURI: string = this.preguntaURI;

    finalURI += '/' + idProducto + '/' + idCalificacion;

    return this.http.get<string>(
      finalURI,
      { withCredentials: true }
    )
  }

  public actualizarPregunta(nPregunta: Pregunta): Observable<string> {
    let finalURI: string = this.preguntaURI;
    
    return this.http.put<string>(
      finalURI,
      nPregunta,
      { withCredentials: true }
    )
  }
}
