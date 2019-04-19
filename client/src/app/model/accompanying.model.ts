import { Meeting } from './meeting.model';

export class Accompanying {
    public id: number;
    public date: Date;
    public mobilityTypeId: number;
    public projectId: number;
    public geographicZone: number;
    public country: string;
    public departure: Date;
    public arrival: Date;
    public duration: number;
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
}
