import { TipoUsuario } from '../TipoUsuario';

export class Usuario {
  public nombre: string;
  public edad: number;
  public foto: string;
  public descripcion: string;
  public correo: string;
  public contrasena: string;
  public tipoUsuario: string;

  constructor(){
    this.nombre = '';
    this.edad = 0;
    this.descripcion = '';
    this.tipoUsuario = 'PROVEEDOR';
    this.correo = '';
    this.contrasena = '';
  }
}