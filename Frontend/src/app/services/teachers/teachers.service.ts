import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Teacher } from '../../model/teacher';

@Injectable({
  providedIn: 'root'
})
export class TeachersService {

  teachersUrl:string = 'http://localhost:8080/api/teacher';

  constructor(private http:HttpClient) { }
  
  getTeachers():Observable<Teacher[]> {
    return this.http.get<Teacher[]>(this.teachersUrl);
  }

  getTeacher(id:any):Observable<Teacher>{
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<Teacher>(this.teachersUrl+`/${id}`);
  }

  save(teachers:Teacher){
    return this.http.post(this.teachersUrl,teachers);
  }

  update(id:number, teachers: Teacher):Observable<Teacher> {
    return this.http.put<teaTeachercher>(this.teachersUrl+`/${id}`, teachers);
  }

  delete(idTeacher: number): Observable<HttpResponse<any>> {
    const url = `${this.teachersUrl}/${idTeacher}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }
}
