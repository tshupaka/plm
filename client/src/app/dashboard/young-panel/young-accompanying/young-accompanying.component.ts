import { Component, OnInit, Input } from '@angular/core';
import { YoungService } from 'src/app/service/young.service';
import { Young } from 'src/app/model/young.model';
import { Accompanying } from 'src/app/model/accompanying.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddMeetingComponent } from './add-meeting/add-meeting.component';
import { DropDownService } from 'src/app/service/drop-down.service';

@Component({
  selector: 'plm-young-accompanying',
  templateUrl: './young-accompanying.component.html',
  styleUrls: ['./young-accompanying.component.css']
})
export class YoungAccompanyingComponent implements OnInit {

  @Input()
  public young: Young;
  private accompanying: Accompanying;

  private dropDownValues: Object;

  constructor(private modalService: NgbModal, private youngService: YoungService, private dropDownService: DropDownService) { }

  ngOnInit() {
    /*if (this.young && this.young.id) {
      this.youngService.getAccompanyingsFromYoung(this.young.id)
        .subscribe((accompanyings: Accompanying[]) => this.accompanyings = accompanyings);
    } else {*/
      this.accompanying = new Accompanying();
   /* }*/
  }


  addNewMeeting() {
    const modalRef = this.modalService.open(AddMeetingComponent);
    modalRef.componentInstance.setParentComponent(this);
  }

  getDropDownValues(key: string) {
    if (this.dropDownValues) {
      let values = this.dropDownValues[key];
      if (!values) {
        values = [];
      }
      return values;
    }
  }

}
