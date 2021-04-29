import {student} from "./student";
import {teacher} from "./teacher";
import {admin} from "./admin";



export class user{
     id?:any;
     username:string;
     password:string;
     students?:student[];
     teachers?:teacher[];
     admins?:admin[];
}