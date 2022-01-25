import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Jwt } from 'src/app/model/jwt';
import { LoginData } from 'src/app/model/login-data';
import { AuthenticationService } from 'src/app/services/authentication-service.service';
import { UserService } from '../users/users.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: LoginData;
  jwt: Jwt | null={value:''};

  constructor(private authenticationService:AuthenticationService, private userService: UserService,
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

  decodePayload(token: string) {
    const jwtData = token.split('.')[1]
    const decodedJwtJsonData = window.atob(jwtData)
    return JSON.parse(decodedJwtJsonData)
  }

  getRoles(token: string) {
    return this.decodePayload(token).roles.map(x => x.authority) || [];
  }


}
