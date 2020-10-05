import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallFlightsComponent } from './listall-flights.component';

describe('ListallFlightsComponent', () => {
  let component: ListallFlightsComponent;
  let fixture: ComponentFixture<ListallFlightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallFlightsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
