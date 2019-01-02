import { User } from './user.model';

export class Awareness {
    public name?: string;
    public date?: Date;
    public typeId?: number;
    public publicId?: number;
    public signature?: boolean;
    public estimation?: number;
    public address1?: string;
    public address2?: string;
    public zipCode?: string;
    public city?: string;
    public geographicFocusId?: number;
    public organiserStructure?: string;
    public contact?: string;
    public comment?: string;
    public users: User[];
}
