import { Injectable } from '@angular/core';
import { Transporte } from '../model/Producto/Transporte';
import { Disponibilidad } from '../model/Disponibilidad';
import { Reserva } from '../model/Reserva';

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
