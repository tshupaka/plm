export class YoungFilter {


    public youngName: string;
    public isAccompaniedYes: boolean;
    public isAccompaniedNo: boolean;
    public isSensitizedYes: boolean;
    public isSensitizedNo: boolean;
    public accompanyingUserId: number;
    public accompanyingTypeId: number;
    public qpvValues: any = {};


    isEmpty(): boolean {

        let isQPVFilter: boolean = false;

        const filter = new Array();
        for (const key in this.qpvValues) {
            isQPVFilter = isQPVFilter || this.qpvValues[key];
        }

        if (this.youngName || this.isAccompaniedYes ||
            this.isAccompaniedNo || this.isSensitizedYes ||
            this.isSensitizedNo || this.accompanyingTypeId ||
            this.accompanyingUserId || isQPVFilter) {
            return false;
        } else {
            return true;
        }
    }

}
