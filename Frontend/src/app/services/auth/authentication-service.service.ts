import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtUtilsService } from './jwt-utils.service';
import { catchError, map } from 'rxjs/operators';

@Injectable()
export class AuthenticationService {

  private readonly loginPath = '/api/users/login';

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService) { }

  login(username: string, password: string): Observable<boolean> {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ username, password }), { headers })
      .pipe(map((res: any) => {
        let token = res && res['token'];
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({
            username: username,
            roles: this.jwtUtilsService.getRoles(token),
            token: token.split(' ')[1]
          }));
          return true;
        }
        else {
          return false;
        }
      }),
      catchError((error: any) => {
        if (error.status === 400) {
          return Observable.throw('Ilegal login');
        }
        else {
          return Observable.throw(error.json().error || 'Server error');
        }
      }));

  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    if (this.getToken() != '') return true;
    else return false;
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return undefined;
    }
  }

}
