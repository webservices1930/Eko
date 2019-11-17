import { Component, OnInit, Input } from '@angular/core';
import { Pregunta } from 'src/app/shared/model/Pregunta';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { Router } from '@angular/router';
import { PreguntaService } from 'src/app/shared/services/pregunta/pregunta.service';

@Component({
  selector: 'app-question-view',
  templateUrl: './question-view.component.html',
  styleUrls: ['./question-view.component.scss']
})
export class QuestionViewComponent implements OnInit {

  @Input() pregunta: Pregunta;
  @Input() puedeResponder: boolean;
  public checkoutForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private utils: UtilsService,
    private router: Router,
    private preguntaService: PreguntaService
  ) {
    this.checkoutForm = this.formBuilder.group({
      respuesta: ['', Validators.required]
    });
    
    // if (this.pregunta.respuesta === '') {
    //   this.yaFueRespondida = false;
    // } else {
    //   this.yaFueRespondida = true;
    // }
  }

  ngOnInit() {
  }

  public onSubmit(nPregunta: Pregunta) {

    this.pregunta.respuesta = nPregunta.respuesta;

    this.preguntaService.actualizarPregunta(this.pregunta)
    .subscribe(result => {
      alert('Pregunta respondida con éxito')
      window.location.reload();
      // this.router.navigate(['home']);
    }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }
}
