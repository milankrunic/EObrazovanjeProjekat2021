import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Student } from '../../model/student';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  studentsUrl:string = 'http://localhost:8080/api/students';

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }
  
  getStudents():Observable<Student[]> {
    console.log("AAAAAAAAAAAAAAa");
    return this.http.get<Student[]>(this.studentsUrl + "/all");
  }

  getStudent(id:any):Observable<Student>{
  //   // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<Student>(this.studentsUrl+`/${id}`);
  }


  save(students:Student){
    return this.http.post(this.studentsUrl,students);
  }

  // update(students:student, id:number):Observable<student> {
  //   return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  // }
  update(id:any, student: Student):Observable<Student> {
    return this.http.put<Student>(this.studentsUrl+`/${id}`, student);
  }

  // edit(users:user, id:number): Observable<HttpResponse<user>> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  // }

  delete(studentId: number): Observable<HttpResponse<any>> {
    const url = `${this.studentsUrl}/${studentId}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}
