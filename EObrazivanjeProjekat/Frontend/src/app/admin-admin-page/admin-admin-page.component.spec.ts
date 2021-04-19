import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAdminPageComponent } from './admin-admin-page.component';

describe('AdminAdminPageComponent', () => {
  let component: AdminAdminPageComponent;
  let fixture: ComponentFixture<AdminAdminPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAdminPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAdminPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
