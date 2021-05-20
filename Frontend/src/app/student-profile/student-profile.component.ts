import { Component, OnInit } from '@angular/core';
import { student } from '../model/student';
import { StudentsService } from '../services/students/students.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {

  student: student = {
    firstName: '',
    lastName: '',
    cardNumber: '',
    email: '',
    userId: ''
  };

  constructor(private studentService: StudentsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getStudent(this.route.snapshot.params["id"])
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

}
