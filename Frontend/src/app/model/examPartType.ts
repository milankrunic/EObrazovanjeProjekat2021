export class examPartType{
    public id: number;
    public name: string;
	public code: string;

    constructor(examPartTypeCfg:examPartType)
    {
        this.id = examPartTypeCfg.id;
        this.name = examPartTypeCfg.name;
        this.code = examPartTypeCfg.code;
    }
}
