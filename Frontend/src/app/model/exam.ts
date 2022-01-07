import { Enrollment } from "./enrollment";

export class Exam{
    public id: number;
    public enrollmentDTO: Enrollment;
    public grade: number;
    public points: number;

    constructor(examCfg:Exam)
    {
        this.id = examCfg.id;
        this.enrollmentDTO= examCfg.enrollmentDTO;
        this.grade = examCfg.grade;
        this.points = examCfg.points;
    }
}

