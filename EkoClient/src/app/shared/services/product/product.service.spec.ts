import { TestBed } from '@angular/core/testing';

import { ProductService } from './product.service';

describe('ProductServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductService = TestBed.get(ProductService);
    expect(service).toBeTruthy();
  });
});
