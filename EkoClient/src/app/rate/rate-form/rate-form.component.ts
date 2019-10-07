import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { Calificacion } from 'src/app/shared/model/Calificacion';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-rate-form',
  templateUrl: './rate-form.component.html',
  styleUrls: ['./rate-form.component.scss']
})
export class RateFormComponent implements OnInit {
  @Input() idProducto: string;
  public checkoutForm: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private utils: UtilsService,
    private router: Router,
    private productService: ProductService
  ) {
    this.checkoutForm = this.formBuilder.group({
      comentario: ['', Validators.required],
      valoracion: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  public onSubmit(nCalificacion: Calificacion) {
    let calificacion: Calificacion = new Calificacion();

    calificacion.comentario = nCalificacion.comentario;
    calificacion.fecha_Creacion = formatDate(new Date(), 'dd/MM/yyy', 'en');
    calificacion.id_Producto = this.idProducto;
    calificacion.id_Usuario = this.userService.obtenerCorreoUsuario();
    calificacion.valoracion = nCalificacion.valoracion;

    this.productService.agregarCalificacionProducto(calificacion)
    .subscribe(result => {
      alert('Calificación enviada con éxito')
      window.location.reload();
      this.router.navigate(['home']);
    }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
