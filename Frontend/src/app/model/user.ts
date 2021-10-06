// import {student} from "./student";
// import {teacher} from "./teacher";
// import {admin} from "./admin";



export class user{
     id?: any;
     firstName: string;
     lastName: string;
     email:string;
     userName: string;
     password: string;
 //    roles: Role[];

     // constructor(userCfg:userInterface)
	// {	
	// 	this.id = userCfg.id;
	// 	this.user_name = userCfg.user_name;
	// 	this.password = userCfg.password;	
	// }
     
}

interface userInterface{
	id?: any;
	user_name:string;
     password:string;
}