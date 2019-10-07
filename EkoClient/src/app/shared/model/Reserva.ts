import { Transporte } from './Producto/Transporte';

export class Reserva {
  public _id: string;
  public fechas: string;
  public clienteid: string;
  public productoid: string;
  //public plan: Plan[];
  //public usuario: Cliente;

  constructor() {
    this._id = '';
    this.fechas = '';
    this.clienteid = '';
    this.productoid = '';
  }
}
