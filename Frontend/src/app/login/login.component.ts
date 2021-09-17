import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication-service.service';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: { user_name?: any; password?: any; };
  public wrongUsernameOrPass:boolean;

  constructor(private authenticationService:AuthenticationService,
    private router: Router) {
      this.user = {};
      this.wrongUsernameOrPass = false;
     }

  ngOnInit(): void {
  }

  login(form:NgForm):void{
    console.log(form.value);
    var user_name: string = form.value.user_name;
    var password: string = form.value.password;

    this.authenticationService.login(user_name, password).subscribe(
      (loggedIn:boolean) => {
        if(loggedIn){
          this.router.navigate(['/admin']);
          console.log('aaaa!!!!')
        }
      }
    ,
    (err:Error) => {
      if(err.toString()==='Ilegal login'){
        this.wrongUsernameOrPass = true;
        console.log(err);
      }
      else{
        throwError(err);
      }
    });
  }
}
