import { Injectable } from '@angular/core';
import { Transporte } from '../model/Producto/Transporte';
import { Disponibilidad } from '../model/Disponibilidad';
import { HttpHeaders } from '@angular/common/http';
import { Usuario } from '../model/Usuario/Usuario';
import { Proveedor } from '../model/Usuario/Proveedor';
import { parseString } from 'xml2js';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  public baseUrl: string = '/api/';

  constructor() { }

  /**
   * Retorna un Objeto XML dado un string
   * 
   * @param stringXML 
   */
  public convertirXMLEnObjeto(stringXML: string): Object {
    let objetoXML: Object = {};

    parseString(stringXML, function (err, respuesta) {
      objetoXML = respuesta;
    });

    return objetoXML;
  }

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

  /**
   * Toma un objeto de tipo transporte y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearTransporteXML(nTransporte: Transporte): string {
    let disponibilidad: string = '';
    let trayectos: string = '';

    // Añade todos los tags de las disponibilidades del producto
    nTransporte.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>'
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>'
      disponibilidad += '</disponibilidad>';
    });

    // Añade todos los tags de trayecto del producto
    nTransporte.trayecto.forEach(trayecto => {
      trayectos += '<trayecto>' + trayecto + '</trayecto>';
    });

    // Construye todo el XML con los datos del producto
    return `
      <transporte xmlns="">
      <_id>` + nTransporte._id + `</_id>
        <descripcion>` + nTransporte.descripcion + `</descripcion>
        `
        + disponibilidad +
        `
        <infoPaisDestino>` + nTransporte.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nTransporte.precio + `</precio>
        <tipo>` + nTransporte.tipo + `</tipo>
        <duracion>` + nTransporte.duracion + `</duracion>
        <horaLlegada>` + nTransporte.horaLlegada + `</horaLlegada>
        <horaSalida>` + nTransporte.horaSalida + `</horaSalida>
        <tipoTransporte>` + nTransporte.tipoTransporte + `</tipoTransporte>
        `
        + trayectos +
      `
    </transporte>`;
  }

  /**
   * Toma un objeto de tipo Usuario y lo transforma en su interpretaicón
   * en XML en el servidor
   * 
   * @param usuario
   */
  public crearUsuarioXML(usuario: Usuario) {
    return `
      <usuario xmlns="">
        <contrasena>` + usuario.contrasena + `</contrasena>
        <correo>` + usuario.correo + `</correo>
        <descripcion>` + usuario.descripcion + `</descripcion>
        <edad>` + usuario.edad + `</edad>
        <nombre>` + usuario.nombre + `</nombre>
        <tipoUsuario>` + usuario.tipoUsuario + `</tipoUsuario>
      </usuario>
    `;
  }

  /**
   * Toma un objeto de tipo Usuario y lo transforma en su interpretaicón
   * en XML en el servidor
   * 
   * @param usuario
   */
  public crearUsuarioProveedorXML(proveedor: Proveedor) {
    return `
      <usuario xmlns="">
        <contrasena>` + proveedor.contrasena + `</contrasena>
        <correo>` + proveedor.correo + `</correo>
        <descripcion>` + proveedor.descripcion + `</descripcion>
        <edad>` + proveedor.edad + `</edad>
        <nombre>` + proveedor.nombre + `</nombre>
        <tipoUsuario>` + proveedor.tipoUsuario + `</tipoUsuario>
        <contactoFacebook>` + proveedor.contactoFacebook + `</contactoFacebook>
        <contactoTwitter>` + proveedor.contactoTwitter + `</contactoTwitter>
        <paginaWeb>` + proveedor.paginaWeb + `</paginaWeb>
        <telefono>` + proveedor.telefono + `</telefono>
      </usuario>
    `;
  }
}
