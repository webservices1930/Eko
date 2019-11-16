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
    
  private usuariosURI: string = this.utils.baseUrl + 'usuarios';

  /**
   * Obtiene todos los productos del Market Place
   */
  public iniciarSesion(usuario: Usuario): Observable<any> {
    let finalURI: string = this.usuariosURI + '?correo=' + usuario.correo + '&contrasena=' + usuario.contrasena;
    
    // Se realiza una petición POST
    return this.http.get<any>(
      finalURI,
      { withCredentials: true }
    );
  }

  /**
   * Registra a un nuevo usuario en el sistema
   * @param nUsuario 
   */
  public registrarUsuario(nUsuario: Usuario): Observable<string> {
    let finalURI: string = this.usuariosURI;
    
    // Se establece la URI para la petición
    if (nUsuario.tipoUsuario === 'CLIENTE') {
      finalURI += '/cliente';
    } else if (nUsuario.tipoUsuario === 'PROVEEDOR') {
      finalURI += '/proveedor';
    }

    // Se realiza una petición POST
    return this.http.post<string>(
      finalURI,
      nUsuario,
      { withCredentials: true }
    );
  }

  public actualizarUsuario(nUsuario: Usuario): Observable<any> {
    const httpOptions: object = this.utils.crearHeadersXML();
    let body: string = '';
    
    // Se crea el vody de la petición SOAP
    if (nUsuario.tipoUsuario == 'CLIENTE') {
      body = `
      <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
          <actualizarUsuarioCliente xmlns="http://iservice.eko.javeriana.edu.co/">
          ` + this.utils.crearUsuarioXML(nUsuario) +  `
          <correo xmlns="">` + nUsuario.correo +  `</correo>
          </actualizarUsuarioCliente>
        </Body>
      </Envelope>
      `;
    } else if (nUsuario.tipoUsuario == 'PROVEEDOR') {
      body = `
      <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
          <actualizarUsuarioProovedor xmlns="http://iservice.eko.javeriana.edu.co/">
          ` + this.utils.crearUsuarioProveedorXML(nUsuario as Proveedor) +  `
          <correo xmlns="">` + nUsuario.correo +  `</correo>
          </actualizarUsuarioProovedor>
        </Body>
      </Envelope>
      `;
    }

    // Se realiza una petición POST
    return this.http.post(
      this.utils.baseUrl + 'eko/usuario?wsdl',
      body,
      httpOptions
    );
  }

  /**
   * Obtiene la información de un usuario por medio de su correo electrónico
   */
  public obtenerInformacionUsuarioActualPorCorreo(): Observable<Usuario> {
    let finalURI: string = this.usuariosURI;
    let tipoUsuario = this.cookieService.get('tipo');
    
    // Se establece la URI para la petición
    if (tipoUsuario === 'CLIENTE') {
      finalURI += '/cliente/correo';
    } else if (tipoUsuario === 'PROVEEDOR') {
      finalURI += '/proveedor/correo';
    }

    finalURI += '?correo=' + this.cookieService.get('usuario');

    // Se realiza una petición POST
    return this.http.get<Usuario>(
      finalURI,
      { withCredentials: true }
    );
  }

  /**
   * Elimina al usuario en sesion del sistema
   * @param nUsuario 
   */
  public eliminarUsuario(): Observable<string> {
    let finalURI: string = this.usuariosURI;
    let tipoUsuario = this.cookieService.get('tipo');
    
    // Se establece la URI para la petición
    if (tipoUsuario === 'CLIENTE') {
      finalURI += '/cliente';
    } else if (tipoUsuario === 'PROVEEDOR') {
      finalURI += '/proveedor';
    }

    finalURI += '?correo=' + this.cookieService.get('usuario') + '&contrasena=' + this.cookieService.get('contrasena');
    console.log(finalURI)

    // Se realiza una petición POST
    return this.http.delete<string>(
      finalURI,
      { withCredentials: true }
    );
  }

  /**
   * Crea una cookie con la información del usuario para saber que ha iniciado sesión
   * @param usuario 
   */
  public crearCookieUsuario(usuario: Usuario) {
    this.cookieService.set('usuario', usuario.correo);
    this.cookieService.set('estado', 'ingresado');
    this.cookieService.set('tipo', usuario.tipoUsuario);
    this.cookieService.set('contrasena', usuario.contrasena);
  }

  /**
   * Elimina la cookie que tenía la información del usuario para saber que ha iniciado sesión
   * @param usuario 
   */
  public eliminarCookieUsuario() {
    this.cookieService.delete('usuario');
    this.cookieService.delete('estado');
    this.cookieService.delete('tipo');
    this.cookieService.delete('contrasena');
  }

  /**
   * Devuelte el correo del usuario en serion
   */
  public obtenerCorreoUsuario() {
    return this.cookieService.get('usuario');
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

  /**
   * Devuelve el tipo de usuario que está en sesión
   */
  public tipoDeUsuario() {
    return this.cookieService.get('tipo');
  }
}
