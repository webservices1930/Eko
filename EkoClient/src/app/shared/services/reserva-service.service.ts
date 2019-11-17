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

  public crearReserva(nReserva: Reserva): Observable<string> {
    return this.http.post<string>(
      this.reservaURI,
      nReserva,
      { withCredentials: true }
    );
  }

  public obtenerReservaPorUsuario(idUsuario: string): Observable<Reserva[]> {
    const finalURI: string = this.reservaURI + 's/cliente/' + idUsuario;
    return this.http.get<Reserva[]>(finalURI, { withCredentials: true });
  }

  public obtenerReserva(id: string): Observable<Reserva> {
    const finalURI: string = this.reservaURI + '/' + id;
    return this.http.get<Reserva>(finalURI, { withCredentials: true });
  }

  public actualizarReserva(nReserva: Reserva): Observable<string> {
    return this.http.put<string>(this.reservaURI, nReserva, { withCredentials: true });
  }

  public eliminarReserva(id: string): Observable<string> {
    const finalURI: string = this.reservaURI + '/' + id;
    return this.http.delete<string>(finalURI, { withCredentials: true });
  }

  public finalizarReserva(id: string): Observable<string> {
    const finalURI: string = this.reservaURI + '/' + id;
    return this.http.put<string>(finalURI, { withCredentials: true });
  }

}
