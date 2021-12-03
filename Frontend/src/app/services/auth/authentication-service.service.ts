import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { JwtUtilsService } from './jwt-utils.service';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { JwtHelperService } from 'angular-jwt';

@Injectable()
export class AuthenticationService {

  private readonly loginPath = 'http://localhost:8080/api/users/login';

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService, private router: Router) { }

  login(user_name: string, password: string): Observable<boolean> {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ user_name, password }), { headers:headers, responseType: "text" })
    .pipe(map((res: any) => {
      let token = res;
      console.log(user_name)
      if (token) {
        console.log("ALO")
        localStorage.setItem('currentUser', JSON.stringify({
          username: user_name, 
          roles: this.jwtUtilsService.getRoles(token),
          token: token
        }));
        return true;
      }
      else {
        console.log("AAAA");
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

  getRole():string{
		const item = localStorage.getItem('loggedUser');
		if (!item) {
			this.router.navigate(['login']);
			return '';
		}

		const jwt: JwtHelperService = new JwtHelperService();
		var	role = jwt.decodeToken(item).roles[0].authority;
		return role;
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


  // private readonly loginPath = 'http://localhost:8080/api/users/login';

  // constructor(
  //   private http: HttpClient,
  //   private jwtUtilsService: JwtUtilsService
  //   ) { }

  // login(user_name: string, password: string): Observable<boolean> {
  //   const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post(this.loginPath, JSON.stringify({ user_name, password }), { headers })
  //     .pipe(map((res: any) => {
  //       console.log(user_name)
  //       const token = res && res.accessToken;
  //       if (!token) {
  //         return false;
  //       }

  //       const lastUserId = JSON.parse(localStorage.getItem('lastUserId'));
  //       if ( lastUserId !== undefined && lastUserId !== this.jwtUtilsService.getId(token)) {
  //         localStorage.clear();
  //         sessionStorage.clear();
  //       }

  //       localStorage.setItem('currentUser', JSON.stringify({
  //         id: this.jwtUtilsService.getId(token),
  //         user_name,
  //         roles: this.jwtUtilsService.getRoles(token),
  //         token
  //       }));

  //       return true;
  //     }));
  // }

  // getToken(): string {
  //   const currentUser = JSON.parse(localStorage.getItem('currentUser'));
  //   const token = currentUser && currentUser.token;
  //   return token ? token : '';
  // }

  // logout(): void {
  //   const user = this.getCurrentUser();
  //   localStorage.removeItem('currentUser');
  //   localStorage.setItem('lastUserId', JSON.stringify(user.id));
  // }

  // isLoggedIn(): boolean {
  //   if (this.getToken() !== '') {
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }

  // getCurrentUser() {
  //   if (localStorage.currentUser) {
  //     return JSON.parse(localStorage.currentUser);
  //   } else {
  //     return undefined;
  //   }
  // }

}
