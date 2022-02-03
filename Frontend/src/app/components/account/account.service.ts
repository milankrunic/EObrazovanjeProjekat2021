import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";
import { Account } from "src/app/model/account";

@Injectable()
export class AccountService {
    private accountsUrl = 'http://localhost:8080/api/account'
    private paymentUrl = 'http://localhost:8080/api/payment'

    constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getAccounts(): Observable<HttpResponse<Account[]>>{
        return this.http.get<Account[]>(this.accountsUrl, {observe: 'response'});
    }

    getAccount(id:number): Observable<HttpResponse<Account>>{
        const url = `${this.accountsUrl}/one-account`;
        return this.http.get<Account>(url, {observe: 'response'});
    }
}