import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-failed-exams',
  templateUrl: './failed-exams.component.html',
  styleUrls: ['./failed-exams.component.css']
})
export class FailedExamsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'Failed exams';

  headers = ["Code", "Exam name", "Teacher", "Hall","Maintenance time"];

  rows = [{
    "Code" : "SIT01",
    "Exam name": "Matematika 1",
    "Teacher" : "Mata Matic",
    "Hall" : "NTP-321",
    "Maintenance time" : "13:30"
  },
  {
    "Code" : "RAM01",
    "Exam name": "Matematika 2",
    "Teacher" : "Mata Matic",
    "Hall" : "NTP-221",
    "Maintenance time" : "14:30"
  }]

}
