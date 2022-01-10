export class examPartStatus{
    public id: number;
    public name: string;
	public code: string;

    constructor(examPartStatusCfg:examPartStatus)
    {
        this.id = examPartStatusCfg.id;
        this.name = examPartStatusCfg.name;
        this.code = examPartStatusCfg.code;
    }
}