import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UtilsService } from '../utils/utils.service';
import { Observable } from 'rxjs';
import { Reserva } from '../model/Reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  private reservaURI: string = this.utils.baseUrl + 'reserva';

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

  /**
   * Genera los Headers para una petición SOAP
   */
  public crearHeadersXML(): object {
    return {
      headers: new HttpHeaders().set('Content-Type', 'text/xml')
        .append('Access-Control-Allow-Methods', 'GET')
        .append('Access-Control-Allow-Origin', '*')
        .append('Access-Control-Allow-Headers', "Access-Control-Allow-Headers, Access-Control-Allow-Origin, Access-Control-Request-Method"),
      responseType: 'text/html',
      withCredentials: true
    };
  }


  public crearReserva(nReserva: Reserva) {
    return this.http.post<string>(
      this.reservaURI,
      nReserva
    );

  }

  public obtenerReservaPorUsuario(idUsuario: string) {
    const finalURI: string = this.reservaURI + 's/cliente/' + idUsuario;
    return this.http.get(finalURI);
  }

  public obtenerReserva(id: string) {
    const finalURI: string = this.reservaURI + '/' + id;
    return this.http.get(finalURI);
  }

  public actualizarReserva(nReserva: Reserva) {
    return this.http.put(this.reservaURI , nReserva);
  }

  public eliminarReserva(id: string) {
    const finalURI: string = this.reservaURI + '/' + id;
    return this.http.delete(finalURI);
  }

}
