import { User } from './user.model';

export class Meeting {
    public id: number;
    public date: Date;
    public description: string;
    public comment: string;
    public user: User;

}
