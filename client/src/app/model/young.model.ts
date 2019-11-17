import { Accompanying } from './accompanying.model';
import { User } from './user.model';

export class Young {

    // Personal Data
    public id?: number;
    public genderId?: number;
    public firstname?: string;
    public lastname: string;
    public birthday?: string;
    public member: boolean;

    // Contact
    public email?: string;
    public phone?: string;
    public facebook?: string;
    public skype?: string;
    public personToContact?:string;

    // Geographic situation
    public address1?: string;
    public address2?: string;
    public zipCode?: string;
    public city?: string;
    public geographicFocusId?: number;
    public qpvStatusId?: number;
    public qpvQuarterId?: number;

    // Organisation contact
    public prescriberId?: number;
    public prescriberType?: number;
    public prescriberDetail?: string;
    public prescriberName?: string;
    public prescriberEmail?: string;
    public prescriberPhone?: string;

    // Education
    public educationLabel?: string;
    public educationLevelId?: number;
    public lastCertificate?: string;
    public englishLevelId?: number;
    public otherLanguage?: string;

    // Professional status
    public employmentStatusId?: number;
    public poleEmploiInscriptionDate?: Date;
    public rsaClaimant: boolean;
    public youngGuarantee: boolean;

    public accompanying: Accompanying;
    public accompanyingType: number;


    public accompanied: boolean;
    public sensitized: boolean;
    public accompanyingUser: User;


}
