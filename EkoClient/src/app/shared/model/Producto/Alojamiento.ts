import { Producto } from './Producto';

export class Alojamiento extends Producto {
  public tipoAlojamiento: string;
  public latitud: number;
  public longitud: number;
  public habitaciones: number;
  public desayuno: boolean;
  public almuerzo: boolean;
  public cena: boolean;
  public internet: boolean;
  public television: boolean;
  public numCamas: number;
  public numBanios: number;

  constructor() {
    super();

    this.tipoAlojamiento = '';
    this.latitud = 0;
    this.longitud = 0;
    this.habitaciones = 0;
    this.desayuno = false;
    this.almuerzo = false;
    this.cena = false;
    this.internet = false;
    this.television = false;
    this.numCamas = 0;
    this.numBanios = 0;
  }
}
