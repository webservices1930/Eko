import { Disponibilidad } from '../Disponibilidad';

export abstract class Producto {
  public _id: string;
  public precio;
  public infoPaisDestino: string;
  public disponibilidad: Disponibilidad[];
  public descripcion: string;
  public tipo: string;
  public idUsuario: string;

  constructor() {
      this._id = '';
      this.precio = 0;
      this.infoPaisDestino = '';
      this.disponibilidad = new Array<Disponibilidad>();
      this.descripcion = '';
      this.tipo = '';
      this.idUsuario = '';
  }
}