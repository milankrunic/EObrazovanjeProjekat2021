import { Component, OnInit } from '@angular/core';
import { user } from 'src/app/model/user';
import { UsersService } from 'src/app/services/users/users.service';
import {Router, Routes} from '@angular/router';
import { student } from 'src/app/model/student';


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  // user = {
  //   username: '',
  //   password: ''
  // }

  student: student;
  // users:user = new user();
  users:user;
  
  submitted = false;
  

  constructor(private userService:UsersService, private router: Router ) { }

  ngOnInit(): void {
    this.submitted = false;
  }

  onSubmit(): void {
    
    this.userService.addStudent(this.users)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        // console.log(this.aaaa);
          console.log(error);
        });
  }
      newUser(): void {
        this.submitted = false;
        this.users = {
          username: '',
          password: ''
        };
      }

      backToUsers() {
        this.router.navigate(['/adminstudents']);
      }

      
}
