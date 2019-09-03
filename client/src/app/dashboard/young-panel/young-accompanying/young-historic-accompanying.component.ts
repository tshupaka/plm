import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { YoungService } from 'src/app/service/young.service';
import { Accompanying } from 'src/app/model/accompanying.model';
import { YoungAccompanyingComponent } from './young-accompanying.component';
import { YoungPopupClosedAccompanyingComponent } from './young-popup-closed-accompanying.component';

@Component({
  selector: 'plm-young-historic-accompanying',
  templateUrl: './young-historic-accompanying.component.html',
  styleUrls: ['./young-historic-accompanying.component.css']
})
export class YoungHistoricAccompanyingComponent implements OnInit {

  @Input()
  public young: Young;

  @Output()
  public accompanyingSaved: EventEmitter<Accompanying> = new EventEmitter<Accompanying>();

  public historicAccompanyings: Accompanying[];

  public accompanyingTypes: Map<number, string>;


  constructor(private modalService: NgbModal, private youngService: YoungService) { }


  ngOnInit() {
    this.initHistoric();
    const types: Array<any> = this.youngService.getAccompanyingTypes();
    this.accompanyingTypes = new Map<number, string>();
    types.forEach(type => this.accompanyingTypes.set(type.value, type.label));
  }

  initHistoric(): any {
    this.youngService.getHistoricAccompanyingsFromYoung(this.young.id)
      .subscribe((accompanyings: Accompanying[]) => this.historicAccompanyings = accompanyings);

  }



  displayHistoricAccompanying(accompanyingId: number) {
    this.youngService.getAccompanyingById(accompanyingId).subscribe((accompanying: Accompanying) => {
      const modalRef = this.modalService.open(YoungPopupClosedAccompanyingComponent,  { windowClass: 'closed-accompanying-modal' });
      modalRef.componentInstance.setAccompanying(accompanying);
      modalRef.componentInstance.setParentComponent(this);
    });

  }

  saveAccompanying(accompanying: Accompanying): any {
    this.accompanyingSaved.emit(accompanying);
  }


  getAccompanyingTypeLabel(typeId: number) {
    return this.accompanyingTypes.get(typeId);
  }
}
