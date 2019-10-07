export class Calificacion {
  public _id: string;
  public valoracion: number;
  public id_Producto: string;
  public id_Usuario: string;
  public comentario: string;
  public fecha_Creacion: string;

  constructor() {
    this._id = '';
    this.valoracion = 0;
    this.id_Producto = '';
    this.id_Usuario = '';
    this.comentario = '';
    this.fecha_Creacion = '';
  }
}