import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { Router } from '@angular/router';
import { UtilsService } from 'src/app/shared/utils/utils.service';

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
    private utils: UtilsService,
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
    this.userService.iniciarSesion(informacionUsuario as Usuario)
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        let usuario: Usuario = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:iniciarSesionResponse'][0]['usuario'][0];
        console.log(usuario);
        this.userService.crearCookieUsuario(informacionUsuario as Usuario);
        window.location.reload();
        this.router.navigate(['home']);
      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });
  }

}
