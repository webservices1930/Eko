import { Disponibilidad } from '../Disponibilidad';

export class Salida {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public tipoSalida: string;
  public duracion: number;
  public trayecto: string[];
  public restriccionEdad: number;
  public guia: string;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';

      this.tipoSalida = '';
      this.duracion = 0;
      this.trayecto = new Array<string>();
      this.restriccionEdad = 0;
      this.guia = '';
  }
}
