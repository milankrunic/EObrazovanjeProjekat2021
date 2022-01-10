import { account } from "./account";

export class payment{
    public id?:number;
    public amount: number;
    public date: Date;
    public name: string;
    public accountDTO: account;

    constructor(paymentCfg:payment)
    {
        this.id = paymentCfg.id;
        this.amount = paymentCfg.amount;
        this.date = paymentCfg.date;
        this.name = paymentCfg.name;
        this.accountDTO = paymentCfg.accountDTO;
    }
}