import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsPriceListComponent } from './products-price-list.component';

describe('ProductsPriceListComponent', () => {
  let component: ProductsPriceListComponent;
  let fixture: ComponentFixture<ProductsPriceListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductsPriceListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsPriceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
