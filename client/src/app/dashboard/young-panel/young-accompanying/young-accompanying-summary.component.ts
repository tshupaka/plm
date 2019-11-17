import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { Accompanying } from 'src/app/model/accompanying.model';
import { YoungService } from 'src/app/service/young.service';
import { YoungHistoricAccompanyingComponent } from './young-historic-accompanying.component';
import { YoungAccompanyingComponent } from './young-accompanying.component';
import { Meeting } from 'src/app/model/meeting.model';

@Component({
  selector: 'plm-young-accompanying-summary',
  templateUrl: './young-accompanying-summary.component.html',
  styleUrls: ['./young-accompanying-summary.component.css']
})
export class YoungAccompanyingSummaryComponent implements OnInit {


  @Input()
  public young: Young;


  @ViewChild(YoungHistoricAccompanyingComponent) youngHistoricAccompanyingComponent: YoungHistoricAccompanyingComponent;
  @ViewChild(YoungAccompanyingComponent) youngAccompanyingComponent: YoungAccompanyingComponent;

  constructor(private youngService: YoungService) { }

  ngOnInit() {

    this.youngService.getCurrentAccompanyingFromYoung(this.young.id)
      .subscribe((accompanying: Accompanying) => {

        if (accompanying) {
          accompanying.meetings = accompanying.meetings.sort((meet1: Meeting, meet2: Meeting) => {
            console.log("1", meet1)
            console.log("2", meet2)
            if (meet1 && meet2) {
              return (new Date(meet1.date).getTime() - new Date(meet2.date).getTime());
            } else {
              return -1;
            }

          });
          console.log(accompanying.meetings);
          this.young.accompanying = accompanying;


        } else {
          this.young.accompanying = new Accompanying();
          this.young.accompanying.date = new Date();
          this.young.accompanying.closed = false;
        }

        this.youngAccompanyingComponent.updateAccompanying(accompanying);

      });
  }


  saveAccompanying(accompanying: Accompanying, fromHistory: boolean) {

    console.log('save local {0}', accompanying);
    this.youngService.saveAccompanying(this.young.id, accompanying).subscribe(
      (accompanying2: Accompanying) => {
        if (!fromHistory) {
          this.young.accompanying = accompanying;
          this.youngAccompanyingComponent.updateAccompanying(accompanying2);
        } else {
          this.youngHistoricAccompanyingComponent.initHistoric();
        }
      });
  }
}

