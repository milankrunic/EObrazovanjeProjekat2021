import { payment } from "./studentPayments";
import { student } from "./student";

export class account{
    public id?:number;
    public amount: number;
    public studentDTO: student;
    public payments:payment[];

    constructor(accountCfg:account)
    {
        this.id = accountCfg.id;
        this.amount = accountCfg.amount;
        this.studentDTO = accountCfg.studentDTO;
        this.payments = accountCfg.payments;
    }
}