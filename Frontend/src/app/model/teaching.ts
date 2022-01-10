import { courseInstance } from "./courseInstance";
import { teacher } from "./teacher";
import { teachingType } from "./teachingType";

export class Teaching{
    public id: number;
    public teachingTypeDTO: teachingType;
	public teacherDTO: teacher;
    public courseInstanceDTO: courseInstance;

    constructor(teachingCfg:Teaching)
    {
        this.id = teachingCfg.id;
        this.teachingTypeDTO = teachingCfg.teachingTypeDTO;
        this.teacherDTO = teachingCfg.teacherDTO;
        this.courseInstanceDTO = teachingCfg.courseInstanceDTO;
    }
}