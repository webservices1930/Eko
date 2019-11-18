import { Component, OnInit, Input } from '@angular/core';
import { WeatherService } from '../shared/weather/weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {
  clima: any;
  pronostico:any =[];
  temperatura = 0;
  @Input() ciudad:string='Bogotá';
  constructor(
    private weatherService: WeatherService
  ) { }

  ngOnInit() {
    this.weatherService.obtenerInformacionClimaPorNombreCiudad(this.ciudad)
    .subscribe(response => {
      this.clima = response;
      this.temperatura = Math.round(this.clima.main.temp - 273.15);
    }, error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });

    this.weatherService.obtenerPronosticoClimaPorNombreCiudad(this.ciudad)
    .subscribe(response => {
      var aux = response;
      let temp = '';
      for(let a of aux.list){
        if (temp != a.dt_txt.substring(0, 10)) {
          temp = a.dt_txt.substring(0, 10);
          console.log('Comparacion: '+temp+' - -'+a.dt_txt.substring(0, 10));
          a.dt_txt = a.dt_txt.substring(0, 10);
          a.main.temp = Math.round(a.main.temp - 273.15);
          this.pronostico.push(a);
        }
      }
      console.log(this.pronostico);

    }, error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });

  }

}
