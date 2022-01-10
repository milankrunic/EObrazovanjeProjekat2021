import { courseSpecification } from "./courseSpecification";
import { enrollment } from "./enrollment";

export class courseInstance{
    id?:any;
    startDate:string;
    endDate:string;
    courseSpecification:courseSpecification;
    //enrollments:enrollment[];
}