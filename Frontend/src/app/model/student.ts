import { enrollment } from './enrollment';
import { account } from './account';
import { document } from './document';
import { user } from './user';

export class student {
    id?:any;
    firstName:string;
    lastName:string;
    cardNumber:string;
    email:string;
    userId:user["id"];
    enrollments?:enrollment[];
    documents?:document[];
    accounts?:account[];
}

