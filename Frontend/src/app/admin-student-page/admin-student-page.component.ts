import { Component, OnInit } from '@angular/core';
import { student } from '../model/student';
import { StudentsService } from '../services/students/students.service';
import { UsersService } from '../services/users/users.service';
import { user } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-admin-student-page',
  templateUrl: './admin-student-page.component.html',
  styleUrls: ['./admin-student-page.component.css']
})
export class AdminStudentPageComponent implements OnInit {
  
  users: user[];
  
// konstruktor se prvi poziva
  constructor(private userService:UsersService) {
   
  }


  ngOnInit() {
    // this.userService.getAll().subscribe(users => {
    //   this.users = users;
    // });
    this.userService.getUsers().subscribe((data: user[]) => {
      console.log(data);
      this.users = data;
    });
  }


  headers = ["id", "first_name", "last_name", "email", "cardNumber", "enrollments", "documents", "accounts"];

}
