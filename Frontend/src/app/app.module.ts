import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

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
import { StudentHeaderComponent } from './student-header/student-header.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AdminAdminPageComponent } from './admin-admin-page/admin-admin-page.component';
import { TeacherHeaderComponent } from './teacher-header/teacher-header.component';
import { FooterComponent } from './footer/footer.component';
import { ErrorComponent } from './error/error.component';
import { AddStudentComponent } from './add components/add-student/add-student.component';
import { AddAdminComponent } from './add components/add-admin/add-admin.component';
import { AddTeacherComponent } from './add components/add-teacher/add-teacher.component';
import { FormsModule } from '@angular/forms';
import { UsersService } from './services/users/users.service';
import { StudentDetailsComponent } from './details components/student-details/student-details.component';
import { AuthenticationService } from './services/auth/authentication-service.service';
import { CanActivateAuthGuard } from './services/auth/can-activate-auth.service';
import { JwtUtilsService } from './services/auth/jwt-utils.service';
import { TokenInterceptorService } from './services/auth/token-interceptor.service';
import { AddAccountComponent } from './add components/add-account/add-account.component';
import { TeacherDetailsComponent } from './details components/teacher-details/teacher-details.component';



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
    MainPageTeacherComponent,
    StudentHeaderComponent,
    AdminHeaderComponent,
    AdminAdminPageComponent,
    TeacherHeaderComponent,
    FooterComponent,
    ErrorComponent,
    AddStudentComponent,
    AddAdminComponent,
    AddTeacherComponent,
    StudentDetailsComponent,
    AddAccountComponent,
    TeacherDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [UsersService,
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
