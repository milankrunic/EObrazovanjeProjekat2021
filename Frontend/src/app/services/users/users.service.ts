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

  get(id:any):Observable<user>{
    // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<user>(this.usersUrl+`/${id}`);
  }

  save(users:user){
    return this.http.post(this.usersUrl,user);
  }

  delete(idUser:any){
    return this.http.delete(this.usersUrl+`/${idUser}`);
  }

  

}
