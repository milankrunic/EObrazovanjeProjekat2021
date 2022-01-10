import { Role } from "./role";

export class User{
    public id?: number;
    public firstName: string;
    public lastName: string;
    public userName: string;
    public password: string;
    public roles: Role[];

    constructor(userCfg:User)
    {
        this.id = userCfg.id;
        this.firstName = userCfg.firstName;
        this.lastName = userCfg.lastName;
        this.userName = userCfg.userName;
        this.password = userCfg.password;
        this.roles = userCfg.roles;
    }
}


/*export class user{
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
}*/