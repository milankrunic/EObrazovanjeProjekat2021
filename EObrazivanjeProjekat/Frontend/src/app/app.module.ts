import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { StudentsSubjectComponent } from './students-subject/students-subject.component';
import { ExamRegistrationComponent } from './exam-registration/exam-registration.component';
import { StudentDocumentsComponent } from './student-documents/student-documents.component';
import { StudentPaymentsComponent } from './student-payments/student-payments.component';
import { AdminCoursesPageComponent } from './admin-courses-page/admin-courses-page.component';
import { AdminExamsPageComponent } from './admin-exams-page/admin-exams-page.component';
import { AdminStudentPageComponent } from './admin-student-page/admin-student-page.component';
import { StudentProfileComponent } from './student-profile/student-profile.component';
import { TeacherProfileComponent } from './teacher-profile/teacher-profile.component';
import { TeacherSchedulingExamsComponent } from './teacher-scheduling-exams/teacher-scheduling-exams.component';
import { StudentExamsReviewComponent } from './student-exams-review/student-exams-review.component';
import { AdminTeacherPageComponent } from './admin-teacher-page/admin-teacher-page.component';
import { FailedExamsComponent } from './failed-exams/failed-exams.component';
import { FinancialAccountComponent } from './financial-account/financial-account.component';
import { MainPageTeacherComponent } from './main-page-teacher/main-page-teacher.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomePageComponent,
    StudentsSubjectComponent,
    ExamRegistrationComponent,
    StudentDocumentsComponent,
    StudentPaymentsComponent,
    AdminCoursesPageComponent,
    AdminExamsPageComponent,
    AdminStudentPageComponent,
    StudentProfileComponent,
    TeacherProfileComponent,
    TeacherSchedulingExamsComponent,
    StudentExamsReviewComponent,
    AdminTeacherPageComponent,
    FailedExamsComponent,
    FinancialAccountComponent,
    MainPageTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
