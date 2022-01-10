import { courseInstance } from "./courseInstance";
import { student } from "./student";

export class enrollment{
    public id: number;
    public studentDTO: student;
    public courseInstanceDTO: courseInstance;

    constructor(enrollmentCfg:enrollment)
    {
        this.id = enrollmentCfg.id;
        this.studentDTO= enrollmentCfg.studentDTO;
        this.courseInstanceDTO = enrollmentCfg.courseInstanceDTO;
    }
}

