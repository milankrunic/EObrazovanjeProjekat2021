export class DocumentType{
    public id: number;
    public name: string;
    public code: string;

    constructor(documentTypeCfg: DocumentType)
    {
        this.id = documentTypeCfg.id;
        this.name= documentTypeCfg.name;
        this.code = documentTypeCfg.code;
    }
}