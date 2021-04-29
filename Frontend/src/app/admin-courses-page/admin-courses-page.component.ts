import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-courses-page',
  templateUrl: './admin-courses-page.component.html',
  styleUrls: ['./admin-courses-page.component.css']
})
export class AdminCoursesPageComponent implements OnInit {

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
