import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-exam-registration',
  templateUrl: './exam-registration.component.html',
  styleUrls: ['./exam-registration.component.css']
})
export class ExamRegistrationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  headers = ["SR", "Subject code", "Subject name", "Teacher", "Date", "Check-in"];

  rows = [{
    "SR" : 1,
    "Subject code": "SIT-04",
    "Subject name" : "Matematika 1",
    "Teacher" : "Pera Peric",
    "Date" : "12.11.2021."
  },
  {
    "SR" : 2,
    "Subject code": "SIT-05",
    "Subject name" : "Web dizajn",
    "Teacher" : "Zika Zikic",
    "Date" : "10.05.2020."
  },
  {
    "SR" : 3,
    "Subject code": "SIT-10",
    "Subject name" : "Menadzment",
    "Teacher" : "Steva Stevic",
    "Date" : "03.07.2021."
  }

  ]

}
