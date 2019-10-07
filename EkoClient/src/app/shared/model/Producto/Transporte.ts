import { Producto } from './Producto';

export class Transporte extends Producto {
  public horaSalida: string;
  public horaLlegada: string;
  public trayecto: string[];
  public tipoTransporte: string;
  public duracion: number;

  constructor() {
      super();
      this.horaLlegada = '';
      this.horaSalida = '';
      this.trayecto = new Array<string>();
      this.tipoTransporte = '';
      this.duracion = 0;
  }
}
