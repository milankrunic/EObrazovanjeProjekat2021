import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExamsPageComponent } from './admin-exams-page.component';

describe('AdminExamsPageComponent', () => {
  let component: AdminExamsPageComponent;
  let fixture: ComponentFixture<AdminExamsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminExamsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExamsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
