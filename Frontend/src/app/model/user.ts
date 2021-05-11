// import {student} from "./student";
// import {teacher} from "./teacher";
// import {admin} from "./admin";



export class user implements userInterface{
     id?:any;
     username:string;
     password:string;
     // students?:student[];
     // teachers?:teacher[];
     // admins?:admin[];

     constructor(userCfg:userInterface)
	{	
		this.id = userCfg.id;
		this.username = userCfg.username;
		this.password = userCfg.password;	
	}
     
}

interface userInterface{
	id?: any;
	username:string;
     password:string;
}