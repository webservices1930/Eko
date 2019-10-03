import { Injectable } from '@angular/core';
import { Transporte } from '../model/Producto/Transporte';
import { Disponibilidad } from '../model/Disponibilidad';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  public baseUrl: string = '/api/';

  constructor() { }

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
}
