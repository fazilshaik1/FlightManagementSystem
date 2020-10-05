import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallPassengersComponent } from './listall-passengers.component';

describe('ListallPassengersComponent', () => {
  let component: ListallPassengersComponent;
  let fixture: ComponentFixture<ListallPassengersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallPassengersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallPassengersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
