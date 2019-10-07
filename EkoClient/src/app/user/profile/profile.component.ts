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
      .subscribe(result => {
        let infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        infoRespuesta = infoRespuesta['S:Envelope']['S:Body'][0];

        if (infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'] !== undefined) {
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoClienteResponse'][0]['usuarioCliente'][0];
        } else if (infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'] !== undefined) {
          this.usuario = infoRespuesta['ns2:buscarUsuarioPorCorreoProveedorResponse'][0]['usuarioProveedor'][0];
        }
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });


    this.productService.buscarPorIDUsuario(this.userService.obtenerCorreoUsuario())
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result);
        this.productos = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:obtenerProductosPorUsuarioResponse'][0]['listaProductosUsuario'];
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
