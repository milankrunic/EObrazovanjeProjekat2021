import { enrollment } from "./enrollment";

export class exam{
    public id: number;
    public enrollmentDTO: enrollment;
    public grade: number;
    public points: number;

    constructor(examCfg:exam)
    {
        this.id = examCfg.id;
        this.enrollmentDTO= examCfg.enrollmentDTO;
        this.grade = examCfg.grade;
        this.points = examCfg.points;
    }
}

