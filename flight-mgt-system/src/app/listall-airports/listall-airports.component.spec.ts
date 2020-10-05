import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallAirportsComponent } from './listall-airports.component';

describe('ListallAirportsComponent', () => {
  let component: ListallAirportsComponent;
  let fixture: ComponentFixture<ListallAirportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallAirportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallAirportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
