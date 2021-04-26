import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-payments',
  templateUrl: './student-payments.component.html',
  styleUrls: ['./student-payments.component.css']
})
export class StudentPaymentsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  headers = ["SR", "Name", "Date", "Amount"];

  rows = [{
    "SR" : 1,
    "Name": "04",
    "Date" : "Matematika 1",
    "Amount": "04"
  },
  {
    "SR" : 2,
    "Name": "05",
    "Date" : "Web dizajn",
    "Amount": "04"
  },
  {
    "SR" : 3,
    "Name": "10",
    "Date" : "Menadzment",
    "Amount": "04"
  }

  ]

}
