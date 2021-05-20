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
    firstName: '',
    lastName: '',
    cardNumber: '',
    email: '',
    userId: ''
  };
    
  constructor(private studentService: StudentsService, private route: ActivatedRoute, private location: Location) {
    
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
          console.log(this.student.firstName);
          console.log(this.student.lastName);
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
