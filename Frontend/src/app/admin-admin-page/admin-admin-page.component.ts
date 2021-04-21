import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-admin-page',
  templateUrl: './admin-admin-page.component.html',
  styleUrls: ['./admin-admin-page.component.css']
})
export class AdminAdminPageComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }

  

  title = 'Admin table';

  headers = ["ID", "Name", "Surname", "Email"];

  rows = [{
    "ID" : "aa",
    "Name": "aaa",
    "Surname" : "aaa",
    "Email" : "aaaa"
  }]

}
