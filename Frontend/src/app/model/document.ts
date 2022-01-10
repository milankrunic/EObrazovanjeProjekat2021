import { student } from "./student";
import { typeDocument } from "./documentType";

export class document{
    public id: number;
    public title: string;
    public url: string;
    public typeDocumentDTO: typeDocument;
    public studentDTO: student;

    constructor(documentCfg: Document)
    {
        this.id = documentCfg.id;
        this.title= documentCfg.title;
        this.url = documentCfg.url;
        this.typeDocumentDTO = documentCfg.typeDocumentDTO;
        this.studentDTO = documentCfg.studentDTO;
    }
}