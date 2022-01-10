export class role{
	public id: number;
	public code: string;
	public name: string;
		
	constructor(roleCfg: role)
	{	
		this.id = roleCfg.id;
        this.code = roleCfg.code;
        this.name = roleCfg.name;			
	}
}