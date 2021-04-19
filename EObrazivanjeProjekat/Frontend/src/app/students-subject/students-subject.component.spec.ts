import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentsSubjectComponent } from './students-subject.component';

describe('StudentsSubjectComponent', () => {
  let component: StudentsSubjectComponent;
  let fixture: ComponentFixture<StudentsSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentsSubjectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentsSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
