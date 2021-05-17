import { Component, OnInit, Output, Input } from '@angular/core';
import { exam } from '../model/exam';
import { ExamsService } from '../services/exams/exams.service';
import { Observable, Subscription } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-exams-page',
  templateUrl: './admin-exams-page.component.html',
  styleUrls: ['./admin-exams-page.component.css']
})
export class AdminExamsPageComponent implements OnInit {

  exams:exam[];

  constructor(private examsService:ExamsService, private router:Router) { 

    subscription: Subscription;
  }

  ngOnInit() {
    this.examsService.getExams().subscribe((data: exam[]) => {
      console.log(data);
      this.exams = data;
    });
  }


  deleteExam(examId: number): void {
    this.examsService.delete(examId).subscribe(
      () => this.examsService.getExams()
    );
    location.reload()
  }

  updateExam(id : number){
    this.router.navigate(['/editexam', id]);
  }
  
  gotoAdd(): void {
    this.router.navigate(['/addexam']);
  }

}
