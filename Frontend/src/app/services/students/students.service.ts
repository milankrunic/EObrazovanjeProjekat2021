import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { student } from '../../model/student';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  studentsUrl:string = 'http://localhost:8080/api/students';

  constructor(private http:HttpClient) { }
  
  getStudents():Observable<student[]> {
    return this.http.get<student[]>(this.studentsUrl);
  }

  getStudent(id:any):Observable<student>{
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<student>(this.studentsUrl+`/${id}`);
  }

  save(students:student){
    return this.http.post(this.studentsUrl,students);
  }

  update(id:number, students: student):Observable<student> {
    return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  }

  delete(studentId: number): Observable<HttpResponse<any>> {
    const url = `${this.studentsUrl}/${studentId}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

 // studentsUrl: '';

 // constructor(private http:HttpClient) { }

 // getStudents() {
      // return [ {
      //   id: 1,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: [1],
      //   documents: [1],
      //   accounts: [1]
      //  },
      //  {
      //   id: 2,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: ["1"],
      //   documents: [1],
      //   accounts: [1]
      //  },
      //  {
      //   id: 3,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: [1],
      //   documents: [1],
      //   accounts: [1]
  
      //  },
      //  ]
 // }
}
