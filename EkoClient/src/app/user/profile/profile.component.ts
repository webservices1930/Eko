import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  private usuario: Usuario = new Usuario();

  constructor(
    private userService: UserService,
    private utils: UtilsService
  ) {

    this.userService.obtenerInformacionUsuarioActualPorCorreo()
      .subscribe(result => {
        let infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        infoRespuesta = infoRespuesta['S:Envelope']['S:Body'][0];

        if (infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'] !== undefined) {
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'][0]['usuarioCliente'][0];
        } else if (infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'] !== undefined) {
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'][0]['usuarioProveedor'][0];
        }
      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });

  }

  ngOnInit() { }

}
