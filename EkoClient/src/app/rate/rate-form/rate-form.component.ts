import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { Calificacion } from 'src/app/shared/model/Calificacion';
import { formatDate } from '@angular/common';
import { CalificacionService } from 'src/app/shared/services/calificacion/calificacion.service';
import { ReservaService } from 'src/app/shared/services/reserva-service.service';

@Component({
  selector: 'app-rate-form',
  templateUrl: './rate-form.component.html',
  styleUrls: ['./rate-form.component.scss']
})
export class RateFormComponent implements OnInit {
  @Input() idProducto: string;
  @Input() idReserva: any;
  public checkoutForm: FormGroup;
  public stars: any = [];
  public valoracion: number = 5;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private utils: UtilsService,
    private router: Router,
    private productService: ProductService,
    private calificacionService: CalificacionService,
    private reservaService: ReservaService
  ) {
    this.checkoutForm = this.formBuilder.group({
      comentario: ['', Validators.required]
    });

    for (let i=1; i<=5; ++i) {
      this.stars.push({
        class: '',
        value: i
      });
    }

    console.log(this.checkoutForm)
  }

  ngOnInit() {
  }

  public onSubmit(nCalificacion: Calificacion) {
    let calificacion: Calificacion = new Calificacion();
    
    calificacion.comentario = nCalificacion.comentario;
    calificacion.fecha_Creacion = formatDate(new Date(), 'dd/MM/yyy', 'en');
    calificacion.id_Producto = this.idProducto;
    calificacion.id_Usuario = this.userService.obtenerCorreoUsuario();
    calificacion.valoracion = this.valoracion;


    this.calificacionService.agregarCalificacion(calificacion)
      .subscribe(resultCalificacion => {
        this.reservaService.finalizarReserva(this.idReserva)
          .subscribe(resultReserva => {
            alert('Reserva eliminada con éxito');
            window.location.reload();
          }, error => {
            console.log('There was an error: ', error);
            console.log(error.status);
          });
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  public seleccionarEstrella(valor: number) {
    this.valoracion = valor;

    for (let i=0; i<5; ++i) {
      if (i < valor) {
        this.stars[i].class = 'selected';
      } else {
        this.stars[i].class = '';
      }
    }
  }
}
