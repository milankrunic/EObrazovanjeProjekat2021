import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
// import { JwtUtilsService } from './jwt-utils.service';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});


  private readonly loginPath = 'http://localhost:8080/api/users/login';
  private readonly logOutPath = 'http://localhost:8080/api/users/logout';

  constructor(private http: HttpClient,
              // private jwtUtilsService: JwtUtilsService, 
              private router: Router) { }

  // login(user_name: string, password: string): Observable<boolean> {
  //   var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post(this.loginPath, JSON.stringify({ user_name, password }), { headers:headers, responseType: "text" })
  //   .pipe(map((res: any) => {
  //     let token = res;
  //     console.log(user_name)
  //     if (token) {
  //       console.log("ALO")
  //       localStorage.setItem('currentUser', JSON.stringify({
  //         username: user_name, 
  //         roles: this.jwtUtilsService.getRoles(token),
  //         token: token
  //       }));
  //       return true;
  //     }
  //     else {
  //       console.log("AAAA");
  //         return false;
  //       }
  //     }),
  //     catchError((error: any) => {
  //       if (error.status === 400) {
  //         return Observable.throw('Ilegal login');
  //       }
  //       else {
  //         return Observable.throw(error.json().error || 'Server error');
  //       }
  //     }));

  // }

  login(auth: any): Observable<any> {
		return this.http.post(this.loginPath, {username: auth.username, password: auth.password}, {headers: this.headers, responseType: 'json'});
	}

  logout(): Observable<any> {
		return this.http.get(this.logOutPath, {headers: this.headers, responseType: 'text'});
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

  isLoggedIn(): boolean {
    if (this.getToken() != '') return true;
    else return false;
  }

  // getCurrentUser() {
  //   if (localStorage.currentUser) {
  //     return JSON.parse(localStorage.currentUser);
  //   }
  //   else {
  //     return undefined;
  //   }
  // }  
  getLoggedUser():string{
		const item = localStorage.getItem('loggedUser');
		if (!item) {
			this.router.navigate(['login']);
			return '';
		}

		const jwt: JwtHelperService = new JwtHelperService();
		var	loggedUser = jwt.decodeToken(item);
		return loggedUser;
	}
}
