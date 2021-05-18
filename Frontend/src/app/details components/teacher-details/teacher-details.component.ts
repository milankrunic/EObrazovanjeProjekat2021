import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { teacher } from 'src/app/model/teacher';
import { Location } from '@angular/common';
import { TeachersService } from 'src/app/services/teachers/teachers.service';

@Component({
  selector: 'app-teacher-details',
  templateUrl: './teacher-details.component.html',
  styleUrls: ['./teacher-details.component.css']
})
export class TeacherDetailsComponent implements OnInit {

  teacher: teacher = {
    firstName: '',
    lastName: '',
    email: '',
    user: ''
  };

  constructor(private teacherService: TeachersService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.getTeacher(this.route.snapshot.params["id"]);
  }

  getTeacher(id: any): void {
    this.teacherService.getTeacher(id)
      .subscribe(
        data => {
            this.teacher = data;
            console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  edit(): void {
    this.teacherService.update(this.teacher.id, this.teacher)
      .subscribe(
        response => {
          console.log(response);
          
        },
        error => {
          console.log(error);
        });
  }

  goBack(): void {
    this.location.back();
  }

}
