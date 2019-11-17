import { Component, OnInit } from '@angular/core';
import { ProductService } from '../shared/services/product/product.service';
import { UtilsService } from '../shared/utils/utils.service';
import { UserService } from '../shared/services/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-market-place',
  templateUrl: './market-place.component.html',
  styleUrls: ['./market-place.component.scss']
})
export class MarketPlaceComponent implements OnInit {
  public productos: any[];
  search:string = '';

  constructor(private productService: ProductService,
    private utils: UtilsService,
    private userService: UserService,
    private router: Router
  ) {
    this.productService.obtenerTodosLosProductos()
      .subscribe(productosResponse => {
        this.productos = productosResponse;
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  ngOnInit() {
  }

  searchInput(){
    this.productService.queryProductos(this.search)
      .subscribe(productosResponse => {
        this.productos = productosResponse;
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  verTodoProductos(){
    this.productService.obtenerTodosLosProductos()
      .subscribe(productosResponse => {
        this.productos = productosResponse;
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }
}
