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
  student: student = new student();

  mode:string;

  constructor(private studentService: StudentsService, private route: ActivatedRoute, private location: Location) {
    
}

ngOnInit() {
  if (this.route.snapshot.params['id']) {
    this.mode = 'EDIT'; 
    // fetch student if we edit the existing student
    this.route.params.pipe(switchMap((params: Params) => 
        this.studentService.getStudent(+params['id']))) // convert to number
      .subscribe(res => {
        this.student = res.id;
      }
      );
  } 
}

edit(): void {
  this.studentService.update(this.student.id, this.student)
    .subscribe(student => {
      this.studentService.announceChange();
      this.goBack();
    });
}

goBack(): void {
  this.location.back();
}

}
