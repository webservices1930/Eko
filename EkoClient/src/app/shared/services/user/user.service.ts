import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../../utils/utils.service';
import { Observable } from 'rxjs';
import { Usuario } from '../../model/Usuario/Usuario';
import { CookieService } from 'ngx-cookie-service';
import { Proveedor } from '../../model/Usuario/Proveedor';

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
    const httpOptions: object = this.utils.crearHeadersXML();

    const body: string = `
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
      <Body>
        <iniciarSesionCliente xmlns="http://iservice.eko.javeriana.edu.co/">
          <correo xmlns="">` + usuario.correo +`</correo>
        </iniciarSesionCliente>
      </Body>
    </Envelope>`;

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/usuarios?wsdl',
      body,
      httpOptions
    );
  }

  public registrarUsuario(nUsuario: Usuario): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();
    let body: string = '';

    // Se crea el vody de la petición SOAP
    if (nUsuario.tipoUsuario === 'CLIENTE') {
      body = `
      <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
          <registrarUsuarioCliente xmlns="http://iservice.eko.javeriana.edu.co/">
          ` + this.utils.crearUsuarioXML(nUsuario) +  `
          </registrarUsuarioCliente>
        </Body>
      </Envelope>
      `;
    } else if (nUsuario.tipoUsuario === 'PROVEEDOR') {
      body = `
      <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
          <registrarUsuarioProveedor xmlns="http://iservice.eko.javeriana.edu.co/">
          ` + this.utils.crearUsuarioProveedorXML(nUsuario as Proveedor) +  `
          </registrarUsuarioProveedor>
        </Body>
      </Envelope>
      `;
    }

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/usuarios?wsdl',
      body,
      httpOptions
    );
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

  /**
   * Verifica si hay un usuario que ha iniciado sesión
   */
  public verificarUsuarioProveedor() {
    return this.cookieService.get('tipo') === 'PROVEEDOR';
  }
}
