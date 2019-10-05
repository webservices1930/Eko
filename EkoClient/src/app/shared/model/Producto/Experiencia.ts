import { Disponibilidad } from '../Disponibilidad';

export class Experiencia {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public tipoExperiencia: string;
  public nivelRiesgo: number;
  public restriccionEdad: number;
  public latitud: number;
  public longitud: number;
  public duracion: number;
  public horaLlegada: number;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';
      this.tipoExperiencia = '';
      this.nivelRiesgo = 0;
      this.restriccionEdad = 0;
      this.latitud = 0;
      this.longitud = 0;
      this.duracion = 0;
      this.horaLlegada = 0;
  }
}
