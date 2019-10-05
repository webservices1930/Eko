import { Disponibilidad } from '../Disponibilidad';

export class Evento {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public tipoEvento: string;
  public nombreEvento: string;
  public restriccionEdad: number;
  public horaApertura: number;
  public horaCierre: number;
  public maxPersonas: number;
  public latitud: number;
  public longitud: number;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';

      this.tipoEvento = '';
      this.nombreEvento = '';
      this.restriccionEdad = 0;
      this.horaApertura = 0;
      this.horaCierre = 0;
      this.maxPersonas = 0;
      this.latitud = 0;
      this.longitud = 0;
  }
}
