import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetScheduledflightComponent } from './get-scheduledflight.component';

describe('GetScheduledflightComponent', () => {
  let component: GetScheduledflightComponent;
  let fixture: ComponentFixture<GetScheduledflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetScheduledflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
