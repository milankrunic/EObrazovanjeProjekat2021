import { Component, OnInit, Output, Input } from '@angular/core';
import { student } from '../model/student';
import { StudentsService } from '../services/students/students.service';
import { UsersService } from '../services/users/users.service';
import { user } from '../model/user';
import { Observable } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-student-page',
  templateUrl: './admin-student-page.component.html',
  styleUrls: ['./admin-student-page.component.css']
})
export class AdminStudentPageComponent implements OnInit {
  
  @Output()
  saveUserEvent = new EventEmitter<user>()

  students:student[];

  users:user[];
  
  // users: user;
  
// konstruktor se prvi poziva
  constructor(private userService:UsersService, private studentsService:StudentsService, private router:Router) {
   
  }


  ngOnInit() {
    // this.userService.getAll().subscribe(users => {
    //   this.users = users;
    // });
    this.userService.getUsers().subscribe((data: user[]) => {
      console.log(data);
      this.users = data;
    });

    this.studentsService.getStudents().subscribe((data: student[]) => {
      console.log(data);
      this.students = data;
    });

   
  }

  // onSubmit() {
  //   this.userService.save(this.users).subscribe(data=>console.log(data), error=>console.log(error));
    
  // }
  
  // deleteUser(id: number) {
  //   this.userService.delete(id)
  //     .subscribe(
  //       data => {
  //         console.log(data);
  //         this.users = this.userService.getUsers();
  //       },
  //       error => console.log(error));
  // }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }

}
