import { Component, OnInit } from '@angular/core';
import { courseInstance } from '../model/courseInstance';
import { CourseInstanceService } from '../services/courseInstance/courseInstance.service';;
import { Observable, Subscription } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-courses-page',
  templateUrl: './admin-courses-page.component.html',
  styleUrls: ['./admin-courses-page.component.css']
})
export class AdminCoursesPageComponent implements OnInit {

  courseInstance:courseInstance[];

  constructor(private courseInstanceService:CourseInstanceService, private router:Router) { }

  ngOnInit() {
    this.courseInstanceService.getCourses().subscribe((data: courseInstance[]) => {
      console.log(data);
      this.courseInstance = data;
    });
  }

  deleteCourse(courseInstanceId: number): void {
    this.courseInstanceService.delete(courseInstanceId).subscribe(
      () => this.courseInstanceService.getCourses()
    );
    location.reload()
  }

  updateCourse(id : number){
    this.router.navigate(['/editcourse', id]);
  }
  
  gotoAdd(): void {
    this.router.navigate(['/addCourse']);
  }
}
