import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { AuthenticationService } from './authentication-service.service';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { HttpEvent } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private inj: Injector) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authenticationService:AuthenticationService = this.inj.get(AuthenticationService);
    request = request.clone({
      setHeaders: {
        'Authorization': `JWT ${authenticationService.getToken()}`
      }
    });

    return next.handle(request);
  }

}