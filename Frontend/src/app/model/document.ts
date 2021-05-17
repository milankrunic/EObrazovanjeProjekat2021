import { documentType } from "./documentType";
import { student } from "./student";

export class document {
    id?:any;
    title:string;
    url:string;
    student:student;
    documentType:documentType;
}