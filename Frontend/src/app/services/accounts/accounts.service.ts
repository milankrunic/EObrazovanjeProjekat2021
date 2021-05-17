import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { account } from '../../model/account';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AccountsService {

    accountsUrl:string = 'http://localhost:8080/api/accounts';

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }
  
  getAccounts():Observable<account[]> {
    return this.http.get<account[]>(this.accountsUrl);
  }

  getAccount(id:any):Observable<account>{
  //   // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<account>(this.accountsUrl+`/${id}`);
  }


  save(accounts:account){
    return this.http.post(this.accountsUrl,accounts);
  }

  // update(students:student, id:number):Observable<student> {
  //   return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  // }
  update(id:any, account: account):Observable<account> {
    return this.http.put<account>(this.accountsUrl+`/${id}`, account);
  }

  // edit(users:user, id:number): Observable<HttpResponse<user>> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  // }

  delete(accountId: number): Observable<HttpResponse<any>> {
    const url = `${this.accountsUrl}/${accountId}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}