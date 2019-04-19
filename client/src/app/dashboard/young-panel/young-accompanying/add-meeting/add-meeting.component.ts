import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { YoungAccompanyingComponent } from '../young-accompanying.component';
import { DropDownService } from 'src/app/service/drop-down.service';
import { Accompanying } from 'src/app/model/accompanying.model';
import { ProjectService } from 'src/app/service/project.service';

@Component({
  selector: 'plm-add-meeting',
  templateUrl: './add-meeting.component.html',
  styleUrls: ['./add-meeting.component.css']
})
export class AddMeetingComponent implements OnInit {

  private youngAccompanyingComponent: YoungAccompanyingComponent;
  private accompayningType: number;
  private accompanying: Accompanying;

  private dropDownValues: Object;


  private CANCEL = 1;
  private POSITIVE_EXIT = 2;
  private ACCOMPANYING = 3;
  private MOBILITY = 4;
  private FOLLOW_END = 5;
  private mobilityProjects: any;



  constructor(private activeModal: NgbActiveModal, private dropDownService: DropDownService) { }


  ngOnInit() {
    this.initDropDownValue();
    this.accompanying = new Accompanying();
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});
      console.log(this.dropDownValues);
    });
  }


  setParentComponent(youngAccompanyingComponent: YoungAccompanyingComponent) {
    this.youngAccompanyingComponent = youngAccompanyingComponent;
  }



  saveMeeting() {

  }


}
