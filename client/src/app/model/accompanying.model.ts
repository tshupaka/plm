import { Meeting } from './meeting.model';

export class Accompanying {
    public id: number;
    public type: number;
    public date: Date;
    public mobilityTypeId: number;
    public projectId: number;
    public geographicZoneId: number;
    public country: string;
    public departureDate: Date;
    public returnDate: Date;
    public durationId: number;
    public endAccompanyingDate: number;
    public endAccompanyingReasonId: number;
    public endAccompanyingComment: string;
    public contactDate3Month: Date;
    public position3MonthId: number;
    public comment3Month: string;
    public contactDate6Month: Date;
    public position6MonthId: number;
    public comment6Month: string;
    public meetings: Meeting[];
    public youngId: number;
    public closed: boolean;
    public foundingId: number;
    public accompanyingUserId: number;

    constructor() {
        this.closed = false;
        this.date = new Date();
    }
}
