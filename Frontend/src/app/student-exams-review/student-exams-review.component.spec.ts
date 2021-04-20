import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentExamsReviewComponent } from './student-exams-review.component';

describe('StudentExamsReviewComponent', () => {
  let component: StudentExamsReviewComponent;
  let fixture: ComponentFixture<StudentExamsReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentExamsReviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentExamsReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
