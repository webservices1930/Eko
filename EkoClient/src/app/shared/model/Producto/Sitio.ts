import { Disponibilidad } from '../Disponibilidad';

export class Sitio {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public tipoSitio: string;
  public latitud: number;
  public longitud: number;
  public restriccionEdad: number;
  public consumoObligatorio: boolean;
  public horaApertura: number;
  public horaCierre: number;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';

      this.tipoSitio = '';
      this.latitud = 0;
      this.longitud = 0;
      this.restriccionEdad = 0;
      this.consumoObligatorio = false;
      this.horaApertura = 0;
      this.horaCierre = 0;
  }
}
