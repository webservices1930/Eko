import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private checkoutForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
    this.checkoutForm = this.formBuilder.group({
      correo: ['', Validators.required],
      contrasena: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  public onSubmit(informacionUsuario: Usuario) {
    informacionUsuario.tipoUsuario = 'CLIENTE'
    this.userService.iniciarSesion(informacionUsuario as Usuario)
      .subscribe(result => {
        console.log('holi')
        this.userService.crearCookieUsuario(informacionUsuario as Usuario);
        this.router.navigate(['home']);
        window.location.reload();
      },
      error =>{
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
