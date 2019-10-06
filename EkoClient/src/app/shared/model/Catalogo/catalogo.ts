export class Catalogo {
  public _id: string;
  public nombre: string;
  public idUsuario: string;
  public productos: string[];
  public precio: number;
  public descripcion: string;

  constructor(){
    this._id = '';
    this.nombre = '';
    this.idUsuario = '';
    this.productos = [];
    this.precio = 0;
    this.descripcion = '';
  }

}

