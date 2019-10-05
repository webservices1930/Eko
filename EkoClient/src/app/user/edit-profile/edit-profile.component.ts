import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/shared/model/TipoUsuario';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Proveedor } from 'src/app/shared/model/Usuario/Proveedor';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  public checkoutForm: FormGroup;
  public tiposDeUsuario: string[];
  public usuario: Usuario = new Usuario();

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private utils: UtilsService,
    private router: Router
  ) {
    this.tiposDeUsuario = Object.keys(TipoUsuario).filter(key => typeof TipoUsuario[key as any] === 'number');

    this.userService.obtenerInformacionUsuarioActualPorCorreo()
      .subscribe(result => {
        let infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        infoRespuesta = infoRespuesta['S:Envelope']['S:Body'][0];
        
        if (infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'] !== undefined) {
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'][0]['usuarioCliente'][0];
        } else if (infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'] !== undefined) {
          this.usuario = new Proveedor();
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'][0]['usuarioProveedor'][0];
        }
        
        this.checkoutForm.setValue({
          nombre: this.usuario.nombre,
          edad: this.usuario.edad,
          descripcion: this.usuario.descripcion,
          tipoUsuario: this.usuario.tipoUsuario,
          correo: this.usuario.correo,
          contrasena: '',
          verificarContrasena: '',
          telefono: this.usuario['telefono'],
          paginaWeb: this.usuario['paginaWeb'],
          contactoFacebook: this.usuario['contactoFacebook'],
          contactoTwitter: this.usuario['contactoTwitter']
        })

      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });

    this.checkoutForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      edad: ['', Validators.required],
      descripcion: ['', Validators.required],
      tipoUsuario: this.userService.tipoDeUsuario(),
      correo: ['', Validators.required],
      contrasena: ['', Validators.required],
      verificarContrasena: ['', Validators.required],
      telefono: '',
      paginaWeb: '',
      contactoFacebook: '',
      contactoTwitter: ''
    });
  }

  ngOnInit() {}

  public onSubmit(informacionUsuario: Usuario) {
    console.log(informacionUsuario)
    this.userService.actualizarUsuario(informacionUsuario)
      .subscribe(result => {
        // window.location.reload();
        this.router.navigate(['user/profile']);
      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });
  }

}
