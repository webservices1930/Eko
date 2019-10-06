import { Disponibilidad } from '../Disponibilidad';

export class Transporte {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;

  public horaSalida: number;
  public horaLlegada: number;
  public trayecto: string[];
  public tipoTransporte: string;
  public duracion: number;


  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';
      this.horaLlegada = 0;
      this.horaSalida = 0;
      this.trayecto = new Array<string>();
      this.tipoTransporte = '';
      this.duracion = 0;
  }
}

 // constructor(
  //   n_id,
  //   nPrecio,
  //   nInfoPaisDestino,
  //   nDisponibilidad,
  //   nDescripcion,
  //   nTipo) {
  //     this._id = n_id;
  //     this.precio = nPrecio;
  //     this.infoPaisDestino = nInfoPaisDestino;
  //     this.disponibilidad = nDisponibilidad;
  //     this.descripcion = nDescripcion;
  //     this.tipo = nTipo;
  // }
