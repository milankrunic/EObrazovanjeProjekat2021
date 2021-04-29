import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { user } from '../../model/user';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  usersUrl:string = 'http://localhost:8080/api/users'


  
  constructor(private http:HttpClient) { }
  
  getUsers():Observable<user[]> {
    return this.http.get<user[]>(this.usersUrl);
  }

}
