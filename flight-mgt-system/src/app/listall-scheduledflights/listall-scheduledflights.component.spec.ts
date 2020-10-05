import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallScheduledflightsComponent } from './listall-scheduledflights.component';

describe('ListallScheduledflightsComponent', () => {
  let component: ListallScheduledflightsComponent;
  let fixture: ComponentFixture<ListallScheduledflightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallScheduledflightsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallScheduledflightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
