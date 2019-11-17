import { Disponibilidad } from '../Disponibilidad';
import { Calificacion } from '../Calificacion';
import { Pregunta } from '../Pregunta';

export abstract class Producto {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;
  public idUsuario: string;
  public calificacion: Calificacion[];
  public pregunta: Pregunta[];

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';
      this.idUsuario = '';
      this.calificacion = new Array<Calificacion>();
      this.pregunta = new Array<Pregunta>();
  }
}