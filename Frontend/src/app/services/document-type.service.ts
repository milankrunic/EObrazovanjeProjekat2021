import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DocumentType } from '../model/documentType';

@Injectable({
  providedIn: 'root'
})
export class DocumentTypeService {

  private examPartType = 'api/document-type';

  constructor(private http: HttpClient) { }

  getDocumentTypes(): Observable<HttpResponse<DocumentType[]>>{
    return this.http.get<DocumentType[]>(this.examPartType, {observe: 'response'});
  }
}