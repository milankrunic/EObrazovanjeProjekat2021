import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherSchedulingExamsComponent } from './teacher-scheduling-exams.component';

describe('TeacherSchedulingExamsComponent', () => {
  let component: TeacherSchedulingExamsComponent;
  let fixture: ComponentFixture<TeacherSchedulingExamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeacherSchedulingExamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherSchedulingExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
