import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  public haySesionDeUsuario: boolean = false;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.verificarEstadoDeSesion();
  }

  public cerrarSesion() {
    this.userService.eliminarCookieUsuario();
    this.router.navigate(['user/login']);
  }

  public verificarEstadoDeSesion() {
    this.haySesionDeUsuario = this.userService.verificiarSesion();
  }

}
