import { Account } from "./account";

export class Payment{
    public id?:number;
    public amount: number;
    public date: Date;
    public name: string;
    public accountDTO: Account;

    constructor(paymentCfg:Payment)
    {
        this.id = paymentCfg.id;
        this.amount = paymentCfg.amount;
        this.date = paymentCfg.date;
        this.name = paymentCfg.name;
        this.accountDTO = paymentCfg.accountDTO;
    }
}