import { exam } from "./exam";
import { examPartType } from "./examPartType";
import { examPartStatus } from "./examPartStatus";
export class examPart{
    public id: number;
    public date: Date;
    public location: String;
    public points: number;
    public examDTO: exam;
    public examPartTypeDTO: examPartType;
    public statusDTO: examPartStatus;

    constructor(examDetailCfg:examPart)
    {
        this.id = examDetailCfg.id;
        this.date= examDetailCfg.date;
        this.location = examDetailCfg.location;
        this.points = examDetailCfg.points;
        this.examDTO = examDetailCfg.examDTO;
        this.examPartTypeDTO= examDetailCfg.examPartTypeDTO;
        this.statusDTO = examDetailCfg.statusDTO;
    }
}
