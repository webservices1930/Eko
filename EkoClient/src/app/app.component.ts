import { Component, OnInit } from '@angular/core';
import { ProductService } from './shared/services/product/product.service';
import { parseString } from 'xml2js';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { ReservaService } from './shared/services/reserva-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'EkoClient';
  id = '';
  idreservas = '';

  lat = 51.678418;
  lng = 7.809007;

  constructor(private router: Router) {
    // this.router.navigate(['user/login']);
  }

  ngOnInit() { }
}
