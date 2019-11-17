import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/services/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Usuario } from 'src/app/shared/model/Usuario/Usuario';
import { Router } from '@angular/router';
import { Proveedor } from 'src/app/shared/model/Usuario/Proveedor';
import { ProductService } from 'src/app/shared/services/product/product.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  public usuario: Usuario | Proveedor = new Usuario();
  public productos: any[] = [];

  constructor(
    private productService: ProductService,
    private userService: UserService,
    private router: Router,
    private utils: UtilsService
  ) {

    this.userService.obtenerInformacionUsuarioActualPorCorreo()
      .subscribe(usuarioResponse => {
        this.usuario = usuarioResponse;
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });


    this.productService.buscarPorIDUsuario(this.userService.obtenerCorreoUsuario())
      .subscribe(productosResponse => {
        this.productos = productosResponse;
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });

  }

  ngOnInit() { }

  public eliminarCuenta() {
    this.userService.eliminarUsuario()
      .subscribe(result => {
        this.userService.eliminarCookieUsuario();
        window.location.reload();
        this.router.navigate(['user/login']);
      },
        error => {
          console.log('There was an error: ', error);
          console.log(error.status);
        });
  }

}
