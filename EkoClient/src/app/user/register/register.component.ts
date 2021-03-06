import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { Proveedor } from 'src/app/shared/model/Usuario/Proveedor';
import { TipoUsuario } from 'src/app/shared/model/TipoUsuario';
import { UtilsService } from 'src/app/shared/utils/utils.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  public checkoutForm: FormGroup;
  public tiposDeUsuario: string[];

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private utils: UtilsService,
    private router: Router
  ) {
    this.tiposDeUsuario = this.utils.valoresDeEnum(TipoUsuario);

    this.checkoutForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      edad: ['', Validators.required],
      foto: ['', Validators.required],
      descripcion: ['', Validators.required],
      tipoUsuario: ['', Validators.required],
      correo: ['', Validators.required],
      contrasena: ['', Validators.required],
      verificarContrasena: ['', Validators.required],
      telefono: '',
      paginaWeb: '',
      contactoFacebook: '',
      contactoTwitter: ''
    });
  }

  ngOnInit() {
  }

  public onSubmit(informacionUsuario: Usuario) {
    this.userService.registrarUsuario(informacionUsuario)
      .subscribe(result => {
        alert('Usuario registrado exitosamente');
        this.router.navigate(['user/login']);
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
