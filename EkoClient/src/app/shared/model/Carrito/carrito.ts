export class Carrito {
  public _id: string;
  public idUsuario: string;
  public productos: string[];

  constructor(){
    this._id = '';
    this.idUsuario = '';
    this.productos = [];
  }
}
