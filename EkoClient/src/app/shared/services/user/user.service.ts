import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Observable } from 'rxjs';
import { Usuario } from '../../model/Usuario/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

  /**
   * Obtiene todos los productos del Market Place
   */
  public iniciarSesion(usuario: Usuario): Observable<any> {
    // const httpOptions: object = this.utils.crearHeadersXML();

    // const body: string = `
    // <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    //   <Body>
    //     <obtenerTodosLosProductos xmlns="http://iservice.eko.javeriana.edu.co/"/>
    //   </Body>
    // </Envelope>`;

    // Se realiza una petición POST
    // return this.http.post(
    //   this.utils.baseUrl + 'eko/market-place?wsdl',
    //   body,
    //   httpOptions
    // );

    const loginObservable = new Observable((observer) => {
      observer.next(() => {
        console.log('holi');
      });
      observer.complete();
    });

    return loginObservable;
  }
}
