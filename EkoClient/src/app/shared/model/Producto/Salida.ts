import { Producto } from './Producto';

export class Salida extends Producto {
  public tipoSalida: string;
  public duracion: number;
  public trayecto: string[];
  public restriccionEdad: number;
  public guia: string;

  constructor() {
    super();

    this.tipoSalida = '';
    this.duracion = 0;
    this.trayecto = new Array<string>();
    this.restriccionEdad = 0;
    this.guia = '';
  }
}
