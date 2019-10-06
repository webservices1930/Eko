import { Injectable } from '@angular/core';
import { Transporte } from '../model/Producto/Transporte';
import { Disponibilidad } from '../model/Disponibilidad';
import { HttpHeaders } from '@angular/common/http';
import { Usuario } from '../model/Usuario/Usuario';
import { Proveedor } from '../model/Usuario/Proveedor';
import { parseString } from 'xml2js';
import { Alojamiento } from '../model/Producto/Alojamiento';
import { Evento } from '../model/Producto/Evento';
import { Experiencia } from '../model/Producto/Experiencia';
import { Salida } from '../model/Producto/Salida';
import { Sitio } from '../model/Producto/Sitio';
import { Reserva } from '../model/Reserva';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  public baseUrl: string = '/api/';

  constructor() { }

  /**
   * Devuelve los valores en string de un enum
   *
   * @param tipoEnum
   */
  public valoresDeEnum(tipoEnum): string[] {
    return Object.keys(tipoEnum).filter(key => typeof tipoEnum[key as any] === 'number');
  }

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

    console.log(nTransporte.infoPaisDestino);
    console.log(nTransporte.descripcion);

    // Construye todo el XML con los datos del producto
    return `
      <transporte xmlns="">
        <_id>` + nTransporte._id + `</_id>
        <descripcion>` + nTransporte.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nTransporte.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nTransporte.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nTransporte.precio + `</precio>
        <tipo>TRANSPORTE</tipo>
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
   * Toma un objeto de tipo ALOJAMIENTO y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearAlojamientoXML(nAlojamiento: Alojamiento): string {
    let disponibilidad: string = '';

    // Añade todos los tags de las disponibilidades del producto
    nAlojamiento.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>'
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>'
      disponibilidad += '</disponibilidad>';
    });

    // Construye todo el XML con los datos del producto
    return `
    <alojamiento xmlns="">
        <_id>` + nAlojamiento._id + `</_id>
        <descripcion>` + nAlojamiento.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nAlojamiento.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nAlojamiento.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nAlojamiento.precio + `</precio>
        <tipo>ALOJAMIENTO</tipo>
        <almuerzo>` + nAlojamiento.almuerzo + `</almuerzo>
        <cena>` + nAlojamiento.cena + `</cena>
        <desayuno>` + nAlojamiento.desayuno + `</desayuno>
        <habitaciones>` + nAlojamiento.habitaciones + `</habitaciones>
        <internet>` + nAlojamiento.internet + `</internet>
        <latitud>` + nAlojamiento.latitud + `</latitud>
        <longitud>` + nAlojamiento.longitud + `</longitud>
        <numBanios>` + nAlojamiento.numBanios + `</numBanios>
        <numCamas>` + nAlojamiento.numCamas + `</numCamas>
        <television>` + nAlojamiento.television + `</television>
        <tipoAlojamiento>` + nAlojamiento.tipoAlojamiento + `</tipoAlojamiento>
    </alojamiento>`;
  }


   /**
   * Toma un objeto de tipo EVENTO y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearEventoXML(nEvento: Evento): string {
    let disponibilidad: string = '';

    // Añade todos los tags de las disponibilidades del producto
    nEvento.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>';
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>';
      disponibilidad += '</disponibilidad>';
    });

    // Construye todo el XML con los datos del producto
    return `
    <evento xmlns="">
    <_id>` + nEvento._id + `</_id>
        <descripcion>` + nEvento.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nEvento.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nEvento.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nEvento.precio + `</precio>
        <tipo>EVENTO</tipo>
        <horaApertura>` + nEvento.horaApertura + `</horaApertura>
        <horaCierre>` + nEvento.horaCierre + `</horaCierre>
        <latitud>` + nEvento.latitud + `</latitud>
        <longitud>` + nEvento.longitud + `</longitud>
        <maxPersonas>` + nEvento.maxPersonas + `</maxPersonas>
        <nombreEvento>` + nEvento.nombreEvento + `</nombreEvento>
        <restriccionEdad>` + nEvento.restriccionEdad + `</restriccionEdad>
        <tipoEvento>` + nEvento.tipoEvento + `</tipoEvento>
    </evento>`;
  }


   /**
   * Toma un objeto de tipo EXPERIENIA y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearExperienciaXML(nExperiencia: Experiencia): string {
    let disponibilidad: string = '';

    // Añade todos los tags de las disponibilidades del producto
    nExperiencia.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>';
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>';
      disponibilidad += '</disponibilidad>';
    });

    // Construye todo el XML con los datos del producto
    return `
    <experiencia xmlns="">
        <_id>` + nExperiencia._id + `</_id>
        <descripcion>` + nExperiencia.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nExperiencia.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nExperiencia.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nExperiencia.precio + `</precio>
        <tipo>EXPERIENCIA</tipo>
        <duracion>` + nExperiencia.duracion + `</duracion>
        <horaLlegada>` + nExperiencia.horaLlegada + `</horaLlegada>
        <latitud>` + nExperiencia.latitud + `</latitud>
        <longitud>` + nExperiencia.longitud + `</longitud>
        <nivelRiesgo>` + nExperiencia.nivelRiesgo + `</nivelRiesgo>
        <restriccionEdad>` + nExperiencia.restriccionEdad + `</restriccionEdad>
        <tipoExperiencia>` + nExperiencia.tipoExperiencia + `</tipoExperiencia>
    </experiencia>`;
  }

  /**
   * Toma un objeto de tipo SALIDA y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearSalidaXML(nSalida: Salida): string {
    let disponibilidad: string = '';
    let trayecto: string = '';
    // Añade todos los tags de las disponibilidades del producto
    nSalida.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>';
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>';
      disponibilidad += '</disponibilidad>';
    });

    nSalida.trayecto.forEach( trayect => {
      let t: string = trayect;
      trayecto += '<trayecto>';
      trayecto += t;
      trayecto += '</trayecto>';
    });

    // Construye todo el XML con los datos del producto
    return `
    <salida xmlns="">
        <_id>` + nSalida._id + `</_id>
        <descripcion>` + nSalida.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nSalida.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nSalida.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nSalida.precio + `</precio>
        <tipo>SALIDA</tipo>
        <duracion>` + nSalida.duracion + `</duracion>
        <guia>` + nSalida.guia + `</guia>
        <restriccionEdad>` + nSalida.restriccionEdad + `</restriccionEdad>
        <tipoSalida>` + nSalida.tipoSalida + `</tipoSalida>
        `
        + trayecto +
        `
    </salida>`;
  }
/**
   * Toma un objeto de tipo SITIO y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearSitioXML(nSitio: Sitio): string {
    let disponibilidad: string = '';

    // Añade todos los tags de las disponibilidades del producto
    nSitio.disponibilidad.forEach(dispo => {
      let dis: Disponibilidad = dispo;

      disponibilidad += '<disponibilidad>';
      disponibilidad += '<cuposDisponibles>' + dis.cuposDisponibles + '</cuposDisponibles>';
      disponibilidad += '<fecha>' + dis.fecha + '</fecha>';
      disponibilidad += '</disponibilidad>';
    });


    // Construye todo el XML con los datos del producto
    return `
    <sitio xmlns="">
        <_id>` + nSitio._id + `</_id>
        <descripcion>` + nSitio.descripcion + `</descripcion>
        `
        + disponibilidad +
        `<idUsuario>` + nSitio.idUsuario + `</idUsuario>
        <infoPaisDestino>` + nSitio.infoPaisDestino + `</infoPaisDestino>
        <precio>` + nSitio.precio + `</precio>
        <tipo>SITIO</tipo>
        <consumoObligatorio>` + nSitio.consumoObligatorio +`</consumoObligatorio>
        <horaApertura>` + nSitio.horaApertura + `</horaApertura>
        <horaCierre>` + nSitio.horaCierre + `</horaCierre>
        <latitud>` + nSitio.latitud + `</latitud>
        <longitud>` + nSitio.longitud + `</longitud>
        <restriccionEdad>` + nSitio.restriccionEdad + `</restriccionEdad>
        <tipoDeSitio>` + nSitio.tipoSitio + `</tipoDeSitio>
    </sitio>`;
  }

  /* Toma un objeto de tipo Usuario y lo transforma en su interpretaicón
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
  /*
   * Toma un objeto de tipo reserva y lo transforma a su interpretación
   * en XML en el servidor
   */
  public crearReservaXML(nReserva: Reserva): string {

   // let fechas: string = '';



    // Añade todos los tags de fechas de la reserva
   /* nReserva.fechas.forEach(fecha => {
      fechas += '<fecha>' + fecha + '</fecha>';
    });*/
    // Construye todo el XML con los datos de la reserva
    return `
    <reserva xmlns="">
    <_id>` + nReserva._id + `</_id>
      <fecha>` + nReserva.fechas + `</fecha>
      <clienteid>`+nReserva.clienteid+`</clienteid>
       <productoid>`+nReserva.productoid+`</productoid>
    </reserva>`;
  }

}
