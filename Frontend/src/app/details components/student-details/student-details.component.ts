import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { user } from 'src/app/model/user';
import {switchMap} from 'rxjs/operators';
import { Location } from '@angular/common';
import { student } from 'src/app/model/student';
import { StudentsService } from 'src/app/services/students/students.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  
  student: student = {
    id:0,
    cardNumber: '',
    userDTO:{
       id:0,
       firstName:'',
       lastName:'',
       email:'',
       userName:'',
       password:'',
 //      roles:[]
    }
  };

  user: user = {
    firstName:'',
    lastName:'',
    email:'',
    userName:'',
    password:'',
  }
    
  constructor(private studentService: StudentsService, private route: ActivatedRoute, private location: Location, userService: UsersService) {
    
}

ngOnInit() {
  this.getStudent(this.route.snapshot.params["id"]);
}

getStudent(id: any): void {
  this.studentService.getStudent(id)
    .subscribe(
      data => {
          this.student = data;
          console.log(data);
          // console.log(this.student.firstName);
          // console.log(this.student.lastName);
      },
      error => {
        console.log(error);
      });
}

edit(): void {
  this.studentService.update(this.student.id, this.student)
    .subscribe(
      response => {
        console.log(response);
        
      },
      error => {
        console.log(error);
      });
}



// edit(): void {
//   this.studentService.update(this.student.id, this.student)
//     .subscribe(student => {
//       this.studentService.announceChange();
//       this.goBack();
//     });
// }

goBack(): void {
  this.location.back();
}

}
