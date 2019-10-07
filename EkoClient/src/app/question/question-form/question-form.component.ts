import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/services/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/shared/services/product/product.service';
import { Pregunta } from 'src/app/shared/model/Pregunta';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.scss']
})
export class QuestionFormComponent implements OnInit {
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
      descripcion: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  public onSubmit(nPregunta: Pregunta) {
    let pregunta: Pregunta = new Pregunta();

    pregunta.descripcion = nPregunta.descripcion;
    pregunta.fecha_Creacion = formatDate(new Date(), 'dd/MM/yyy', 'en');
    pregunta.id_Producto = this.idProducto;
    pregunta.id_Usuario = this.userService.obtenerCorreoUsuario();
    pregunta.respuesta = '';

    this.productService.agregarPreguntaProducto(pregunta)
    .subscribe(result => {
      alert('Pregunta enviada con éxito')
      window.location.reload();
      this.router.navigate(['home']);
    }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

}
