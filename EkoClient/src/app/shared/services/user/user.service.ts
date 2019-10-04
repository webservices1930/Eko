import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Observable } from 'rxjs';
import { Usuario } from '../../model/Usuario/Usuario';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService,
    private cookieService: CookieService
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

  /**
   * Crea una cookie con la información del usuario para saber que ha iniciado sesión
   * @param usuario 
   */
  public crearCookieUsuario(usuario: Usuario) {
    this.cookieService.set('usuario', usuario.correo);
    this.cookieService.set('estado', 'ingresado');
    this.cookieService.set('tipo', usuario.tipoUsuario.toString());
  }

  /**
   * Elimina la cookie que tenía la información del usuario para saber que ha iniciado sesión
   * @param usuario 
   */
  public eliminarCookieUsuario() {
    this.cookieService.delete('usuario');
    this.cookieService.delete('estado');
    this.cookieService.delete('tipo');
  }

  /**
   * Verifica si hay un usuario que ha iniciado sesión
   */
  public verificiarSesion() {
    return this.cookieService.check('estado');
  }
}
