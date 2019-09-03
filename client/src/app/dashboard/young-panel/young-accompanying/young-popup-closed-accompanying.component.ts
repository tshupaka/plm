import { Component, OnInit, ViewChild } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { Accompanying } from 'src/app/model/accompanying.model';
import { YoungHistoricAccompanyingComponent } from './young-historic-accompanying.component';
import { YoungAccompanyingComponent } from './young-accompanying.component';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'plm-young-popup-closed-accompanying',
  templateUrl: './young-popup-closed-accompanying.component.html',
  styleUrls: ['./young-popup-closed-accompanying.component.css']
})
export class YoungPopupClosedAccompanyingComponent implements OnInit {



  public accompanying: Accompanying;
  public youngHistoricAccompanyingComponent: YoungHistoricAccompanyingComponent;

  @ViewChild(YoungAccompanyingComponent) youngAccompanyingComponent: YoungAccompanyingComponent;

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit() {
  }


  setAccompanying(accompanying: Accompanying) {
    this.accompanying = accompanying;
    this.youngAccompanyingComponent.updateAccompanying(accompanying);
  }
  setParentComponent(youngHistoricAccompanyingComponent: YoungHistoricAccompanyingComponent) {
    this.youngHistoricAccompanyingComponent = youngHistoricAccompanyingComponent;
  }


  saveAccompanying() {
    this.youngHistoricAccompanyingComponent.saveAccompanying(this.accompanying);
    this.activeModal.dismiss();
  }

}
