import { courseSpecification } from "./courseSpecification";

export class courseInstance{
    public id: number;
    public startDate: Date;
	public endDate: Date;
    public courseSpecificationDTO: courseSpecification;

    constructor(courseInstanceCfg:courseInstance)
    {
        this.id = courseInstanceCfg.id;
        this.startDate = courseInstanceCfg.startDate;
        this.endDate = courseInstanceCfg.endDate;
        this.courseSpecificationDTO = courseInstanceCfg.courseSpecificationDTO;
    }
}