export class typeDocument{
    public id: number;
    public name: string;
    public code: string;

    constructor(typeDocumentCfg: typeDocument)
    {
        this.id = typeDocumentCfg.id;
        this.name= typeDocumentCfg.name;
        this.code = typeDocumentCfg.code;
    }
}