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
import { Pregunta } from '../model/Pregunta';
import { Calificacion } from '../model/Calificacion';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  // public baseUrl: string = 'https://eko-server-test.herokuapp.com/api/';
  public baseUrl: string = 'http://localhost:8080/api/';

  constructor() { }

  /**
   * Devuelve los valores en string de un enum
   *
   * @param tipoEnum
   */
  public valoresDeEnum(tipoEnum): string[] {
    return Object.keys(tipoEnum).filter(key => typeof tipoEnum[key as any] === 'number');
  }
}
