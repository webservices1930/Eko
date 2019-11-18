import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/shared/model/TipoUsuario';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Proveedor } from 'src/app/shared/model/Usuario/Proveedor';
import { ReservaService } from '../../shared/services/reserva-service.service';
import { Reserva } from '../../shared/model/Reserva';

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
      .subscribe(usuarioResponse => {
        this.usuario = usuarioResponse;

        this.checkoutForm.setValue({
          nombre: this.usuario.nombre,
          edad: this.usuario.edad,
          foto: this.usuario.foto,
          descripcion: this.usuario.descripcion,
          tipoUsuario: this.usuario.tipoUsuario,
          correo: this.usuario.correo,
          contrasena: '',
          verificarContrasena: '',
          telefono: this.usuario['telefono'] === undefined ? '' : this.usuario['telefono'],
          paginaWeb: this.usuario['paginaWeb'] === undefined ? '' : this.usuario['paginaWeb'],
          contactoFacebook: this.usuario['contactoFacebook'] === undefined ? '' : this.usuario['contactoFacebook'],
          contactoTwitter: this.usuario['contactoTwitter'] === undefined ? '' : this.usuario['contactoTwitter']
        })

      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });

    this.checkoutForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      edad: ['', Validators.required],
      foto: ['', Validators.required],
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
