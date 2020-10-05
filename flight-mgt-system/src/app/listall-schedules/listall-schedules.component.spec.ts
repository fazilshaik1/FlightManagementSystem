import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallSchedulesComponent } from './listall-schedules.component';

describe('ListallSchedulesComponent', () => {
  let component: ListallSchedulesComponent;
  let fixture: ComponentFixture<ListallSchedulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallSchedulesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallSchedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
