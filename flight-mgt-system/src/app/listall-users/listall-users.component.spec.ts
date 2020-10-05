import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListallUsersComponent } from './listall-users.component';

describe('ListallUsersComponent', () => {
  let component: ListallUsersComponent;
  let fixture: ComponentFixture<ListallUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListallUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListallUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
