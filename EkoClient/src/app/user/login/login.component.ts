import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { CookieService } from 'ngx-cookie-service';

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
    private cookieService: CookieService
  ) {
    this.checkoutForm = this.formBuilder.group({
      correo: '',
      contrasena: ''
    });
  }

  ngOnInit() {
  }

  public onSubmit(data) {
    console.warn('Submited', data);
    this.checkoutForm.reset();

    this.userService.iniciarSesion(new Usuario())
      .subscribe(result => {
        console.log(result);
        this.cookieService.set('user', data.correo);
        this.cookieService.set('login', 'logged');
        alert('Sesión iniciada');
      },
      error =>{
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
