import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-page-teacher',
  templateUrl: './main-page-teacher.component.html',
  styleUrls: ['./main-page-teacher.component.css']
})
export class MainPageTeacherComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'My courses table';

  headers = ["Course name", "Exam name", "Teacher", "ESPB"];

  rows = [{
    "Course name" : "Mehatronika",
    "Exam name": "Matematika 1",
    "Teacher" : "Mata Matic",
    "ESPB" : "8"
  },
  {
    "Course name" : "RAM",
    "Exam name": "Matematika 2",
    "Teacher" : "Mata Matic",
    "ESPB" : "6"

  }]

}


