import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private checkoutForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService
  ) {
    this.checkoutForm = this.formBuilder.group({
      correo: '',
      contrasena: ''
    });
  }

  ngOnInit() {
  }

  public onSubmit(data) {
    this.checkoutForm.reset();

    this.userService.iniciarSesion(new Usuario())
      .subscribe(result => {
        this.userService.crearCookieUsuario(data as Usuario);
        alert('Sesión iniciada');
      },
      error =>{
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
