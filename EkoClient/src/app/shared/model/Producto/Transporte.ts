import { Producto } from './Producto';

export class Transporte extends Producto {
  public horaSalida: number;
  public horaLlegada: number;
  public trayecto: string[];
  public tipoTransporte: string;
  public duracion: number;

  constructor() {
      super();
      this.horaLlegada = 0;
      this.horaSalida = 0;
      this.trayecto = new Array<string>();
      this.tipoTransporte = '';
      this.duracion = 0;
  }
}
