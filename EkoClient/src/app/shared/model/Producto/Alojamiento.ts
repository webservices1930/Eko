import { Disponibilidad } from '../Disponibilidad';

export class Alojamiento {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public tipoAlojamiento: string;
  public latitud: number;
  public longitud: number;
  public habitaciones: number;
  public desayuno: boolean;
  public almuerzo: boolean;
  public cena: boolean;
  public internet: boolean;
  public television: boolean;
  public numeroCamas: number;
  public numeroBaños: number;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';

      this.tipoAlojamiento = '';
      this.latitud = 0;
      this.longitud = 0;
      this.habitaciones = 0;
      this.desayuno = false;
      this.almuerzo = false;
      this.cena = false;
      this.internet = false;
      this.television = false;
      this.numeroCamas = 0;
      this.numeroBaños = 0;
  }
}
