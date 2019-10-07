import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-view-small',
  templateUrl: './product-view-small.component.html',
  styleUrls: ['./product-view-small.component.scss']
})
export class ProductViewSmallComponent implements OnInit {
  @Input() producto: any;
  @Input() canEdit: boolean = false;

  constructor(private router: Router) {}

  ngOnInit() {
  }

}
