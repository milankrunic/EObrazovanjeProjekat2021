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
    AdminStudentPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
