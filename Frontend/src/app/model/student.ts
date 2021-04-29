import { enrollment } from './enrollment';
import { account } from './account';
import { document } from './document';

export class student {
    id?:any;
    first_name:string;
    last_name:string;
    cardNumber:string;
    email:string;
    enrollments?:enrollment[];
    documents?:document[];
    accounts?:account[];
}

