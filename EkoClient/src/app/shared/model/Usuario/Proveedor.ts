import { Usuario } from './Usuario';

export class Proveedor extends Usuario {
  public telefono: string;
  public paginaWeb: string;
  public contactoFacebook: string;
  public contactoTwitter: string;

  constructor() {
    super();
    this.telefono = '';
    this.paginaWeb = '';
    this.contactoFacebook = '';
    this.contactoTwitter = '';
    this.tipoUsuario = 'PROVEEDOR';
  }
}