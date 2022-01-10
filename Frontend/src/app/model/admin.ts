/*export class admin{

    id?:any;
    firstName:string;
    lastName:string;
    email:string;
    
}*/

import { user } from "./user";

export class admin{
    public id: number;
    public userDTO: user;

    constructor(adminCfg:admin)
    {
        this.id = adminCfg.id;
        this.userDTO = adminCfg.userDTO;
    }
}