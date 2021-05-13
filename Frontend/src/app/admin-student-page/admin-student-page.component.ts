import { Component, OnInit, Output, Input } from '@angular/core';
import { student } from '../model/student';
import { StudentsService } from '../services/students/students.service';
import { UsersService } from '../services/users/users.service';
import { user } from '../model/user';
import { Observable, Subscription } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-student-page',
  templateUrl: './admin-student-page.component.html',
  styleUrls: ['./admin-student-page.component.css']
})
export class AdminStudentPageComponent implements OnInit {

  students:student[];

  
  
// konstruktor se prvi poziva
  constructor(private studentsService:StudentsService, private router:Router) {
   
  subscription: Subscription;

  }


  ngOnInit() {
    this.studentsService.getStudents().subscribe((data: student[]) => {
      console.log(data);
      this.students = data;
    });
  }


  deleteStudent(studentId: number): void {
    this.studentsService.delete(studentId).subscribe(
      () => this.studentsService.getStudents()
    );
    location.reload()
  }

  updateStudent(id: number){
    this.router.navigate(['/editstudent', id]);
  }
  
  gotoAdd(): void {
    this.router.navigate(['/addStudent']);
    
  }
  
}
