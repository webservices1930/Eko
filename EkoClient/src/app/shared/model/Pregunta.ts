export class Pregunta {
  public _id: string;
  public id_Producto: string;
  public id_Usuario: string;
  public descripcion: string;
  public respuesta: string;
  public fecha_Creacion: string;

  constructor() {
    this._id = '';
    this.id_Producto = '';
    this.id_Usuario = '';
    this.descripcion = '';
    this.respuesta = '';
    this.fecha_Creacion = '';
  }
}