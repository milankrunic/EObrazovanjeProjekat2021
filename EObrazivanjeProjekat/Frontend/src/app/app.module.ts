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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomePageComponent,
    StudentsSubjectComponent,
    ExamRegistrationComponent,
    StudentDocumentsComponent,
    StudentPaymentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
