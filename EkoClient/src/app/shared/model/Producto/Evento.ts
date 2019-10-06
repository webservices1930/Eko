import { Producto } from './Producto';

export class Evento extends Producto {
  public tipoEvento: string;
  public nombreEvento: string;
  public restriccionEdad: number;
  public horaApertura: number;
  public horaCierre: number;
  public maxPersonas: number;
  public latitud: number;
  public longitud: number;

  constructor() {
    super();

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
