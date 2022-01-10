export class teachingType{
    public id: number;
    public name: string;
	public code: number;

    constructor(teachingTypeCfg:teachingType)
    {
        this.id = teachingTypeCfg.id;
        this.name = teachingTypeCfg.name;
        this.code = teachingTypeCfg.code;
    }
}