import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UtilsService } from '../utils/utils.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(
    private http: HttpClient,
    private utils: UtilsService
  ) { }

  public obtenerInformacionClimaPorNombreCiudad(nombreCiudad): Observable<any> {
    return this.http.get(this.utils.weatherURI(nombreCiudad));
  }

  public obtenerPronosticoClimaPorNombreCiudad(nombreCiudad): Observable<any> {
    return this.http.get(this.utils.forecastURI(nombreCiudad));
  }

  public obtenerInformacionCapital(codigoPais): Observable<any> {
    console.log(this.utils.capitalURI(codigoPais))
    return this.http.get(this.utils.capitalURI(codigoPais));
  }
}
