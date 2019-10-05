import { Injectable } from '@angular/core';
import { Transporte } from '../model/Producto/Transporte';
import { Disponibilidad } from '../model/Disponibilidad';
import { Alojamiento } from '../model/Producto/Alojamiento';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  constructor() { }

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
    return `<alojamiento xmlns="">
      <descripcion>` + nAlojamiento.descripcion + `</descripcion>
      `
      + disponibilidad +
      `
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
      <numBaños>` + nAlojamiento.numeroBaños + `</numBaños>
      <numCamas>` + nAlojamiento.numeroCamas + `</numCamas>
      <television>` + nAlojamiento.television + `</television>
      <tipoAlojamiento>` + nAlojamiento.tipoAlojamiento + `</tipoAlojamiento>
  </alojamiento>`;
  }
}
