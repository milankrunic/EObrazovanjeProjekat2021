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

  student: student;
  users:user = new user();
  submitted = false;

  constructor(private userService:UsersService, private router: Router ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.userService.save(this.users)
    .subscribe(data => console.log(data), error => console.log(error));
    this.users = new user();
    // this.router.navigate(['/adminstudents']);
    console.log(this.users);
  }
}
