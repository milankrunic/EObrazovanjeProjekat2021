import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { courseInstance } from '../../model/courseInstance';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CourseInstanceService {

    courseInstanceUrl:string = 'http://localhost:8080/api/course_instance';

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }
  
  getCourses():Observable<courseInstance[]> {
    return this.http.get<courseInstance[]>(this.courseInstanceUrl);
  }

  getCourse(id:any):Observable<courseInstance>{
  //   // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<courseInstance>(this.courseInstanceUrl+`/${id}`);
  }


  save(courseInstances:courseInstance){
    return this.http.post(this.courseInstanceUrl,courseInstances);
  }

  // update(students:student, id:number):Observable<student> {
  //   return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  // }
  update(id:any, courseInstance: courseInstance):Observable<courseInstance> {
    return this.http.put<courseInstance>(this.courseInstanceUrl+`/${id}`, courseInstance);
  }

  // edit(users:user, id:number): Observable<HttpResponse<user>> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  // }

  delete(courseInstanceId: number): Observable<HttpResponse<any>> {
    const url = `${this.courseInstanceUrl}/${courseInstanceId}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}