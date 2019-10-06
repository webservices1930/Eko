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
  public esUsuarioProveedor: boolean = false;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.verificarEstadoDeSesion();
    this.verificarTipoDeUsuario();
  }

  /**
   * Cierra la sesión de un usuario
   */
  public cerrarSesion() {
    this.userService.eliminarCookieUsuario();
    window.location.reload();
    this.router.navigate(['user/login']);
  }

  /**
   * Verifica si hay un usuario que ha iniciado sesión
   */
  public verificarEstadoDeSesion() {
    this.haySesionDeUsuario = this.userService.verificiarSesion();
  }

  /**
   * Verifica si el usuario que está en sersión es proveedor o no
   */
  public verificarTipoDeUsuario() {
    this.esUsuarioProveedor = this.userService.verificarUsuarioProveedor();
  }

}
