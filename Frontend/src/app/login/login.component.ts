import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication-service.service';
import { Router } from '@angular/router';
import { LoginData } from '../model/login-data';
import { Jwt } from '../model/jwt';
import { UsersService } from '../services/users/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: LoginData;
  jwt: Jwt | null={value:''};

  constructor(private authenticationService:AuthenticationService, private userService: UsersService,
    private router: Router) {
      this.loginData = new LoginData('','');
     }

  ngOnInit(): void {
  }

  logIN(): void {
    this.userService.login(this.loginData)
      .subscribe(res => {
        this.jwt=res.body==null ? {value:''}:res.body;
        localStorage.setItem('loggedUser', JSON.stringify({
            username: this.loginData.username,
            roles: this.getRoles(this.jwt.value),
            token: this.jwt
          }));

        
        if(this.authenticationService.getRole()!=null){
          if(this.authenticationService.getRole()==='ROLE_ADMINISTRATOR'){
            this.router.navigate(['/admin']); // za sad
          }else{
            if(this.authenticationService.getRole()==='ROLE_STUDENT'){
              this.router.navigate(['/student/:id']);
            }else{
              this.router.navigate(['/teacher']); //za sad
            }
          } 
        }else{
          alert("Pogresni login podaci!")
        }

      });
  }

  getRoles(token: string) {
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);
    console.log(JSON.stringify(decodedJwtData))

    return [decodedJwtData.role];
  }

}
