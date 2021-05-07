import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { teacher } from '../../model/teacher';

@Injectable({
  providedIn: 'root'
})
export class TeachersService {

  teachersUrl:string = 'http://localhost:8080/api/teacher';

  constructor(private http:HttpClient) { }
  
  getTeachers():Observable<teacher[]> {
    return this.http.get<teacher[]>(this.teachersUrl);
  }

  getTeacher(id:any):Observable<teacher>{
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<teacher>(this.teachersUrl+`/${id}`);
  }

  save(teachers:teacher){
    return this.http.post(this.teachersUrl,teachers);
  }

  update(id:number, teachers: teacher):Observable<teacher> {
    return this.http.put<teacher>(this.teachersUrl+`/${id}`, teachers);
  }

  delete(idTeacher:any){
    return this.http.delete(this.teachersUrl+`/${idTeacher}`);
  }
}
