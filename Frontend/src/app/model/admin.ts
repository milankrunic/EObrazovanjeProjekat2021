/*export class admin{

    id?:any;
    firstName:string;
    lastName:string;
    email:string;
    
}*/

import { User } from "./user";

export class Admin{
    public id: number;
    public userDTO: User;

    constructor(adminCfg:Admin)
    {
        this.id = adminCfg.id;
        this.userDTO = adminCfg.userDTO;
    }
}