import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  adminUrl:string = 'http://localhost:8080/api/admin'

  constructor(private http:HttpClient) { }

  getAdmins():Observable<admin[]> {
    return this.http.get<admin[]>(this.adminUrl);
  }

  delete(idAdmin: number): Observable<HttpResponse<any>> {
    const url = `${this.adminUrl}/${idAdmin}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }
}
