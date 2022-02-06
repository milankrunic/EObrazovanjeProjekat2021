import { Injectable } from '@angular/core';

@Injectable()
export class JwtUtilsService {

    constructor() { }

    getRoles(token:string){
      let jwtData=token.split('.')[1];
      let decodedJWTJsonData=window.atob(jwtData);
      let decodedJWTData=JSON.parse(decodedJWTJsonData);
  
      return [decodedJWTData.roles];
  
    }
    getUsername(token:string){
     
        let jwtData=token.split('.')[1];
        let decodedJWTJsonData=window.atob(jwtData);
        let decodedJWTData=JSON.parse(decodedJWTJsonData);
    
        return [decodedJWTData.sub];
    
    }

}
