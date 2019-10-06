import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UtilsService } from '../utils/utils.service';
import { Observable } from 'rxjs';
import { Reserva } from '../model/Reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  private baseUrl: string = '/api/';

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



  public buscarPorID(id: string) {
    const httpOptions: object = this.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <buscarReservasClientePorID xmlns="http://iservice.eko.javeriana.edu.co/">
          <clienteID xmlns="">` + id + `</clienteID>
        </buscarReservasClientePorID>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.baseUrl + 'eko/market-place?wsdl',
      body,
      httpOptions
    );
  }
}
