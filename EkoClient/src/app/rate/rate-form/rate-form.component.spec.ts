import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateFormComponent } from './rate-form.component';

describe('RateFormComponent', () => {
  let component: RateFormComponent;
  let fixture: ComponentFixture<RateFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
