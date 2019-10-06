import { Producto } from './Producto';

export class Experiencia extends Producto {
  public tipoExperiencia: string;
  public nivelRiesgo: number;
  public restriccionEdad: number;
  public latitud: number;
  public longitud: number;
  public duracion: number;
  public horaLlegada: number;

  constructor() {
    super();

    this.tipoExperiencia = '';
    this.nivelRiesgo = 0;
    this.restriccionEdad = 0;
    this.latitud = 0;
    this.longitud = 0;
    this.duracion = 0;
    this.horaLlegada = 0;
  }
}
