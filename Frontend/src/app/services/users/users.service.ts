import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { user } from '../../model/user';
import { Observable, Subject } from 'rxjs';
import { LoginData } from 'src/app/model/login-data';
import { Jwt } from 'src/app/model/jwt';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  usersUrl:string = 'http://localhost:8080/api/users'
  loginUrl:string = 'http://localhost:8080/api/users/login'

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }

  login(loginData: LoginData): Observable<HttpResponse<Jwt>> {
    return this.http.post<Jwt>(this.loginUrl, loginData, {observe: 'response'});
}
  
  // getUsers():Observable<any[]> {
  //   return this.http.get<user[]>(this.usersUrl);
  // }

  getUsers(): Observable<HttpResponse<user[]>> {
    return this.http.get<user[]>(this.usersUrl, {observe: 'response'});
  }

  // get(id:any):Observable<user>{
  //   return this.http.get<user>(`${this.usersUrl}/${id}`);
  // }

  getUser(id: number): Observable<HttpResponse<user>> {
    const url = `${this.usersUrl}/${id}`;
    return this.http.get<user>(url, {observe: 'response'});
    
  }

  // save(users):Observable<any>{
  //   return this.http.post(this.usersUrl,users);
  // }

  addStudent(users: user): Observable<HttpResponse<user>> {
    return this.http.post<user>(this.usersUrl, users, {observe: 'response'});
  }

  // update(id:number, users: user):Observable<user> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users);
  // }

  // delete(id:any){
  //   return this.http.delete(this.usersUrl+`/${id}`);
  // }

  edit(users:user, id:number): Observable<HttpResponse<user>> {
    return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  }

  delete(id: number): Observable<HttpResponse<any>> {
      const url = `${this.usersUrl}/${id}`;
      return this.http.delete<any>(url, {observe: 'response'});
  }
  

}
