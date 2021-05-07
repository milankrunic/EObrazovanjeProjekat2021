import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { teacher } from '../model/teacher';
import { TeachersService } from '../services/teachers/teachers.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-teacher-page',
  templateUrl: './admin-teacher-page.component.html',
  styleUrls: ['./admin-teacher-page.component.css']
})
export class AdminTeacherPageComponent implements OnInit {

  @Output()
  saveTeacherEvent = new EventEmitter<teacher>()

  teachers: teacher[];

  constructor(private teachersService:TeachersService, private router:Router) { }

  ngOnInit(): void {
    this.teachersService.getTeachers().subscribe((data: teacher[]) => {
      console.log(data);
      this.teachers = data;
    });
  }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }

}
