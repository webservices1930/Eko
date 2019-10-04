import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user/user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public cerrarSesion() {
    this.userService.eliminarCookieUsuario();
  }

}
