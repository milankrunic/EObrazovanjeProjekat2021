import { courseInstance } from "./courseInstance";

export class courseSpecification{
    id?:any;
    title:string;
    ects:number;
    code:string;
    courseInstance:courseInstance[];
}