import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacher-scheduling-exams',
  templateUrl: './teacher-scheduling-exams.component.html',
  styleUrls: ['./teacher-scheduling-exams.component.css']
})
export class TeacherSchedulingExamsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'Teacher schedule exams table';

  headers = ["Name of exam", "Date and Time", "Teacher"];

  rows = [{
    "Name of exam" : "Osnove programiranja",
    "Date and Time": "10.04.2021 17:30",
    "Teacher" : "Petar Petrovic"
  },
  {
    "Name of exam" : "Osnove softverskih arhitektura",
    "Date and Time": "08.04.2021 14:00",
    "Teacher" : "Petar Petrovic"
  },
  {
    "Name of exam" : "XML tehnologije",
    "Date and Time": "05.04.2021 12:30",
    "Teacher" : "Petar Petrovic"
  }]


}
