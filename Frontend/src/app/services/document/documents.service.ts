import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { document } from '../../model/document';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DocumentsService {

documentsUrl:string = 'http://localhost:8080/api/documents';

  constructor(private http:HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }
  
  getDocuments():Observable<document[]> {
    return this.http.get<document[]>(this.documentsUrl);
  }

  getDocument(id:any):Observable<document>{
  //   // const params: HttpParams = new HttpParams().set('_id',id);
    return this.http.get<document>(this.documentsUrl+`/${id}`);
  }


  save(documents:document){
    return this.http.post(this.documentsUrl,documents);
  }

  // update(students:student, id:number):Observable<student> {
  //   return this.http.put<student>(this.studentsUrl+`/${id}`, students);
  // }
  update(id:any, document: document):Observable<document> {
    return this.http.put<document>(this.documentsUrl+`/${id}`, document);
  }

  // edit(users:user, id:number): Observable<HttpResponse<user>> {
  //   return this.http.put<user>(this.usersUrl+`/${id}`, users, {observe: 'response'});
  // }

  delete(Id: number): Observable<HttpResponse<any>> {
    const url = `${this.documentsUrl}/${Id}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}