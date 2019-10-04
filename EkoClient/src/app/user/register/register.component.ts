import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { Proveedor } from 'src/app/shared/model/Usuario/Proveedor';
import { TipoUsuario } from 'src/app/shared/model/TipoUsuario';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  private checkoutForm: FormGroup;
  private tiposDeUsuario: string[];

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
    console.log(TipoUsuario.CLIENTE)
    this.tiposDeUsuario = Object.keys(TipoUsuario).filter(key => typeof TipoUsuario[key as any] === 'number');
    this.checkoutForm = this.formBuilder.group({
      nombre: '',
      edad: '',
      descripcion: '',
      tipoUsuario: '',
      correo: '',
      contrasena: '',
      verificarContrasena: '',
      telefono: '',
      paginaWeb: '',
      contactoFacebook: '',
      contactoTwitter: ''
    });
  }

  ngOnInit() {
  }

  public onSubmit(data) {
    console.log(data);
    // this.checkoutForm.reset();
  }

}
