import { TipoUsuario } from '../TipoUsuario';

export class Usuario {
  public nombre: string;
  public edad: number;
  public descripcion: string;
  public tipoUsuario: string;
  public correo: string;
  public contrasena: string;

  constructor(){
    this.nombre = '';
    this.edad = 0;
    this.descripcion = '';
    this.tipoUsuario = 'PROVEEDOR';
    this.correo = '';
    this.contrasena = '';
  }
}