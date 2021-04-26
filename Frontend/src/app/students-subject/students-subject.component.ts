import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-students-subject',
  templateUrl: './students-subject.component.html',
  styleUrls: ['./students-subject.component.css']
})
export class StudentsSubjectComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  headers = ["Subject code", "Subject name", "Teacher", "Classroom", "Time"];

  rows = [{
    "Subject code" : "SITO1",
    "Subject name" : "Matematika 1",
    "Teacher" : "Pera Peric",
    "Classroom" : "NTP-310",
    "Time" : "Ponedeljak 14:30"
  },
  {
    "Subject code" : "RAM04",
    "Subject name" : "Web programiranje",
    "Teacher" : "Jova Jovic",
    "Classroom" : "NTP-321",
    "Time" : "Sreda 15:00"
  },
  {
    "Subject code" : "SITO5",
    "Subject name" : "Engleski jezik 2",
    "Teacher" : "Dragana Zivic",
    "Classroom" : "NTP-302",
    "Time" : "Petak 16:00"
  }

  ]

}
