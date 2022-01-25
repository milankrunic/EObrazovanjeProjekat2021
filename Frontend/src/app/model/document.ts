import { Student } from "./student";
import { DocumentType } from "./documentType";

export class Document{
    public id: number;
    public title: string;
    public url: string;
    public documentTypeDTO: DocumentType;
    public studentDTO: Student;

    constructor(documentCfg: Document)
    {
        this.id = documentCfg.id;
        this.title= documentCfg.title;
        this.url = documentCfg.url;
        this.documentTypeDTO = documentCfg.documentTypeDTO;
        this.studentDTO = documentCfg.studentDTO;
    }
}