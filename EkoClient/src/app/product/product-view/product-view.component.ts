import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from 'src/app/shared/services/product/product.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';


@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.scss']
})
export class ProductViewComponent implements OnInit {
  public producto: any;
  public tipo: string = '';
  public id: string = '';
  public productoCargado: boolean = false;

  constructor(
    private productService: ProductService,
    private utils: UtilsService,
    // private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.tipo = this.route.snapshot.paramMap.get('tipo');
    this.id = this.route.snapshot.paramMap.get('id');
    this.productService.buscarPorID(this.id)
      .subscribe(result => {
        const infoRespuesta = this.utils.convertirXMLEnObjeto(result as string);
        this.producto = infoRespuesta['S:Envelope']['S:Body'][0]['ns2:buscarProductoPorIdResponse'][0]['producto'][0];
        this.productoCargado = true;
        console.log(this.producto)
      }, error => {
        console.log('There was an error: ', error);
        console.log(error.status);
      });
  }

  ngOnInit() {
  }
}
