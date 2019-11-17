import { Component, OnInit, Input } from '@angular/core';
import { WeatherService } from '../shared/weather/weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {
  clima: any;
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
      console.log(this.clima);
    }, error =>{
      console.log('There was an error: ', error);
      console.log(error.status);
    });
  }

}
