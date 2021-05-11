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

  users:user[];
  
  // users: user;
  
// konstruktor se prvi poziva
  constructor(private userService:UsersService, private studentsService:StudentsService, private router:Router) {
   
  subscription: Subscription;

  // constructor(private userService:UsersService, private router:Router) {
  //   this.subscription = userService.RegenerateData$.subscribe(() =>
  //   this.getUsers());
  //   console.log(this.users);
  }
  // constructor(private studentService: StudentService, private router: Router) {
  //   this.subscription = studentService.RegenerateData$.subscribe(() =>
  //     this.getStudents()
  //   );
  // }

  // ngOnInit(): void {
  //   this.getStudents();
  // }

  // getStudents() {
  //   this.studentService.getStudents().subscribe(
  //     res => this.students = res.body);
  // }

  ngOnInit() {
    // this.userService.getUsers().subscribe((data: user[]) => {
    //   console.log(data);
    //   this.users = data;
    // });

    this.studentsService.getStudents().subscribe((data: student[]) => {
      console.log(data);
      this.students = data;
    });

   
  }

  // onSubmit() {
  //   this.userService.save(this.users).subscribe(data=>console.log(data), error=>console.log(error));
    
  // }
  
  // deleteStudent(id: number) {
  //   this.studentsService.delete(id)
  //     .subscribe(
  //       data => {
  //         console.log(data);
  //         this.studentsService.getStudents();
  //       },
  //       error => console.log(error));
  // }

  deleteStudent(studentId: number): void {
    this.studentsService.delete(studentId).subscribe(
      () => this.studentsService.getStudents()
    );
    location.reload()
  }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }
  
  // gotoAdd(): void {
  //   this.router.navigate(['/addStudent']);
  // }
  //   this.getUsers();
  // }

  // getUsers() {
  //   this.userService.getUsers().subscribe(
  //     res => this.users = res.body);
  // }

  // editUser(users:user): void {
  //   console.log(users.id);
  //   this.router.navigate(['/editstudent', users.id]);
  // }

  // addUser() {
  //   this.router.navigate(['/addstudent']);
  // }


  // deleteUser(id: number): void {
  //   this.userService.delete(id).subscribe(
  //     () => this.getUsers()
  //   );
  // }
  
  


}
