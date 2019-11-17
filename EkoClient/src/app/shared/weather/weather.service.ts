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

  public obtenerLatitudLongitudCiudad(nombreCiudad): Observable<any> {
    return this.http.get(this.utils.weatherURI(nombreCiudad));
  }
}
