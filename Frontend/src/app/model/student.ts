import { user } from "./user";

export class student{
    public id: number;
    public cardNumber: string;
    public userDTO: user;

    constructor(studentCfg:student)
    {
        this.id = studentCfg.id;
        this.cardNumber = studentCfg.cardNumber;
        this.userDTO = studentCfg.userDTO;
    }
}   