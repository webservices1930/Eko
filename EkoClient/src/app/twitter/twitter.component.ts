import { Component, OnInit, Input } from '@angular/core';
import { TwitterResponse } from '../shared/model/twitter-response';
import { ProductService } from '../shared/services/product/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-twitter',
  templateUrl: './twitter.component.html',
  styleUrls: ['./twitter.component.scss']
})
export class TwitterComponent implements OnInit {
  tweets: any = [];
  @Input() query:string ='';
  constructor(
    private productService: ProductService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.productService.twitter(this.query)
    .subscribe(response => {
      this.tweets = response;
      console.log(this.tweets);
    }, error => {
      console.log('There was an error: ', error);
      console.log(error.status);
    });

  }

}
