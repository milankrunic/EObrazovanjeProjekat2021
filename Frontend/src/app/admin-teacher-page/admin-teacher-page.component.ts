import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-teacher-page',
  templateUrl: './admin-teacher-page.component.html',
  styleUrls: ['./admin-teacher-page.component.css']
})
export class AdminTeacherPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'All teachers';

  headers = ["ID", "Name", "Surname", "Email"];

  rows = [{
    "ID" : "1",
    "Name": "Ivan",
    "Surname" : "Stankovic",
    "Email" : "ivan@ivan.com"
  },
  {
    "ID" : "2",
    "Name": "Mata",
    "Surname" : "Matic",
    "Email" : "maya@mata.com"
  }]

}
