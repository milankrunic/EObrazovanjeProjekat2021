import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { ErrorComponent } from './error/error.component';
import { AppComponent } from './app.component';
import { StudentProfileComponent } from './student-profile/student-profile.component';
import { MainPageTeacherComponent } from './main-page-teacher/main-page-teacher.component';
import { StudentPaymentsComponent } from './student-payments/student-payments.component';
import { StudentDocumentsComponent } from './student-documents/student-documents.component';
import { ExamRegistrationComponent } from './exam-registration/exam-registration.component';
import { StudentsSubjectComponent } from './students-subject/students-subject.component';
import { AdminAdminPageComponent } from './admin-admin-page/admin-admin-page.component';
import { AdminStudentPageComponent } from './admin-student-page/admin-student-page.component';
import { AdminTeacherPageComponent } from './admin-teacher-page/admin-teacher-page.component';
import { AdminExamsPageComponent } from './admin-exams-page/admin-exams-page.component';
import { AdminCoursesPageComponent } from './admin-courses-page/admin-courses-page.component';
import { AddStudentComponent } from './add components/add-student/add-student.component';
import { StudentDetailsComponent } from './details components/student-details/student-details.component';
import { CanActivateAuthGuard } from './services/auth/can-activate-auth.service';
import { TeacherDetailsComponent } from './details components/teacher-details/teacher-details.component';

// import { BrowserModule } from '@angular/platform-browser';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'admin', component: AdminHomePageComponent},
  { path: 'admin-students', component: AdminStudentPageComponent},
  { path: 'admin-teachers', component: AdminTeacherPageComponent},
  { path: 'admin-admins', component: AdminAdminPageComponent},
  { path: 'adminexams', component: AdminExamsPageComponent},
  { path: 'admincourses', component: AdminCoursesPageComponent},
  { path: 'addStudent', component: AddStudentComponent },
  { path: 'student', component: StudentProfileComponent},
  { path: 'teacher', component: MainPageTeacherComponent},
  { path: 'exam-registration', component: ExamRegistrationComponent },
  { path: 'student-documents', component: StudentDocumentsComponent },
  { path: 'student-payments', component: StudentPaymentsComponent },
  { path: 'student-subject', component: StudentsSubjectComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'editstudent/:id', component: StudentDetailsComponent },
  { path: 'editteacher/:id', component: TeacherDetailsComponent },
  {path: "**", component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes,{enableTracing: true})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
