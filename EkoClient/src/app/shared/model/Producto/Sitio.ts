import { Producto } from './Producto';

export class Sitio extends Producto {
  public tipoSitio: string;
  public latitud: number;
  public longitud: number;
  public restriccionEdad: number;
  public consumoObligatorio: boolean;
  public horaApertura: string;
  public horaCierre: string;

  constructor() {
    super();

    this.tipoSitio = '';
    this.latitud = 0;
    this.longitud = 0;
    this.restriccionEdad = 0;
    this.consumoObligatorio = false;
    this.horaApertura = '';
    this.horaCierre = '';
  }
}
