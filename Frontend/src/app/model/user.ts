// import {student} from "./student";
// import {teacher} from "./teacher";
// import {admin} from "./admin";



export class user implements userInterface{
     id?:any;
     user_name:string;
     password:string;
     // students?:student[];
     // teachers?:teacher[];
     // admins?:admin[];

     constructor(userCfg:userInterface)
	{	
		this.id = userCfg.id;
		this.user_name = userCfg.user_name;
		this.password = userCfg.password;	
	}
     
}

interface userInterface{
	id?: any;
	user_name:string;
     password:string;
}