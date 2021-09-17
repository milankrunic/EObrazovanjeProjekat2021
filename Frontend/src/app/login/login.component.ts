import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication-service.service';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';

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

  login():void{
    console.log(this.user.user_name);
    console.log(this.user.password);
    this.authenticationService.login(this.user.user_name, this.user.password).subscribe(
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
