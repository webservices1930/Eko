import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductViewSmallComponent } from './product-view-small.component';

describe('ProductViewSmallComponent', () => {
  let component: ProductViewSmallComponent;
  let fixture: ComponentFixture<ProductViewSmallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductViewSmallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductViewSmallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
