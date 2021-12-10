import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { AuthenticationService } from './authentication-service.service';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { HttpEvent } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { Jwt } from 'src/app/model/jwt';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  private jwt: Jwt={value:''};

  constructor(private inj: Injector)  { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    //let authenticationService:AuthenticationService = this.inj.get(AuthenticationService); 
    var j = localStorage.getItem('loggedUser')?.split(":");
    var l = j === undefined ? 0:j?.length
    var token = j===undefined?'':j[l-1].split("\"")[1];
    this.jwt = token==null ? this.jwt:{value:token};
    req = req.clone({
      setHeaders: {
        'X-Auth-Token': this.jwt.value
      }
    });

    return next.handle(req);

  }

}