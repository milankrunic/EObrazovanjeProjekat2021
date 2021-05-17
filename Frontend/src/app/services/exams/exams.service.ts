import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { exam } from '../../model/exam';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ExamsService {

    examsUrl:string = 'http://localhost:8080/api/exams';

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }
  
  getExams():Observable<exam[]> {
    return this.http.get<exam[]>(this.examsUrl);
  }

  getExam(id:any):Observable<exam>{
  //   // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<exam>(this.examsUrl+`/${id}`);
  }


  save(exams:exam){
    return this.http.post(this.examsUrl,exams);
  }

  // update(students:student, id:number):Observable<student> {
  //   return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  // }
  update(id:any, exam: exam):Observable<exam> {
    return this.http.put<exam>(this.examsUrl+`/${id}`, exam);
  }

  // edit(users:user, id:number): Observable<HttpResponse<user>> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  // }

  delete(examId: number): Observable<HttpResponse<any>> {
    const url = `${this.examsUrl}/${examId}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}