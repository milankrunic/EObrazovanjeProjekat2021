import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FailedExamsComponent } from './failed-exams.component';

describe('FailedExamsComponent', () => {
  let component: FailedExamsComponent;
  let fixture: ComponentFixture<FailedExamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FailedExamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FailedExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
