import { user } from "./user";

export class teacher{
    public id: number;
    public userDTO: user;

    constructor(teacherCfg:teacher)
    {
        this.id = teacherCfg.id;
        this.userDTO = teacherCfg.userDTO;
    }
}