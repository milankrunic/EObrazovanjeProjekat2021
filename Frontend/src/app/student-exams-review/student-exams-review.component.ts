import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-exams-review',
  templateUrl: './student-exams-review.component.html',
  styleUrls: ['./student-exams-review.component.css']
})
export class StudentExamsReviewComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'Student exams review table';

  headers = ["Row number", "Subject ID", "Subject name", "ECTS", "Teacher", "Grade"];

  rows = [{
    "Row number" : "1",
    "Subject ID": "SIT04",
    "Subject name" : "Mathematics",
    "ECTS" : "8",
    "Teacher" : "Milos Milakovic",
    "Grade" : "8"
  },
  {
    "Row number" : "2",
    "Subject ID": "SIT01",
    "Subject name" : "Object Oriented Programming",
    "ECTS" : "8",
    "Teacher" : "Milorad Miloradovic",
    "Grade" : "7"
  },
  {
    "Row number" : "3",
    "Subject ID": "SIT02",
    "Subject name" : "English",
    "ECTS" : "4",
    "Teacher" : "Ana Bursac",
    "Grade" : "10"
  }]
  
}
