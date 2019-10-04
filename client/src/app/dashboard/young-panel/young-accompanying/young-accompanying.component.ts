import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { YoungService } from 'src/app/service/young.service';
import { Young } from 'src/app/model/young.model';
import { Accompanying } from 'src/app/model/accompanying.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddMeetingComponent } from './add-meeting/add-meeting.component';
import { DropDownService } from 'src/app/service/drop-down.service';
import { Meeting } from 'src/app/model/meeting.model';
import { isFulfilled } from 'q';
import { NgForm } from '@angular/forms';
import { ProjectService } from 'src/app/service/project.service';
import { Project } from 'src/app/model/project.model';

import { Observable, timer } from 'rxjs';
import { User } from 'src/app/model/user.model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'plm-young-accompanying',
  templateUrl: './young-accompanying.component.html',
  styleUrls: ['./young-accompanying.component.css']
})
export class YoungAccompanyingComponent implements OnInit {

  @Input()
  public accompanyingId: number;

  @Output()
  accompanyingSaved: EventEmitter<Accompanying> = new EventEmitter<Accompanying>();


  public accompanying: Accompanying = new Accompanying();

  public dropDownValues: Object;

  public mobilityProjects: Project[];

  public mobilityDisplay = false;

  public endMobilityDisplay = false;


  public errorMessage: string;
  public successMessage: string;

  public users: User[];

  constructor(private modalService: NgbModal, private youngService: YoungService,
    private dropDownService: DropDownService, private projectService: ProjectService, private userService: UserService) { }

  ngOnInit() {
    this.projectService.getAllProjects().subscribe(projects => this.mobilityProjects = projects);
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});

    });
    this.userService.getAllUsers().subscribe(users => this.users = users);
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

  handleAddMeeting(meeting: Meeting, addMeeting: boolean) {
    if (!this.accompanying.meetings) {
      this.accompanying.meetings = new Array();
    }
    if (addMeeting) {
      this.accompanying.meetings.push(meeting);
    }
    /*this.awarenesses.push(awareness);*/
  }


  saveAccompanying(form: NgForm) {
    if (form.valid) {
      this.accompanyingSaved.emit(this.accompanying);
      this.successMessage = 'Accompagnement enregistré avec succès.';
      timer(3000).subscribe(() => this.successMessage = undefined);
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
      timer(3000).subscribe(() => this.errorMessage = undefined);
    }
  }

  closeCurrentAccompanying() {
    if (confirm('Êtes-vous sûr de vouloir fermer ce projet ?')) {
      this.accompanying.closed = true;
      this.accompanyingSaved.emit(this.accompanying);
    }
  }

  updateAccompanying(accompanying: Accompanying) {
    this.accompanying = accompanying;
    if (this.accompanying && this.accompanying.type) {
      this.changeAccompanyingType(this.accompanying.type.toString());
    }
  }

  changeProject(projectId: any) {
    const selectedProjects: Project[] = this.mobilityProjects.filter(project => project.id == projectId);
    if (selectedProjects && selectedProjects.length > 0) {

      const selectedProject = selectedProjects[0];
      console.log(selectedProjects);
      this.accompanying.geographicZoneId = selectedProject.geographicZoneId;
      this.accompanying.country = selectedProject.country;
      this.accompanying.departureDate = selectedProject.departureDate;
      this.accompanying.returnDate = selectedProject.returnDate;
      this.accompanying.durationId = selectedProject.durationId;
    }


  }

  changeAccompanyingType(accompanyingType: string) {
    console.log('Type : ' + accompanyingType);
    const type = parseInt(accompanyingType, 10);
    switch (type) {
      case 1:
      case 2:
      case 3:
      case 4:
        this.mobilityDisplay = false;
        this.endMobilityDisplay = false;
        break;
      case 5:
      case 6:
        this.mobilityDisplay = true;
        this.endMobilityDisplay = false;
        break;
      case 7:
        this.mobilityDisplay = true;
        this.endMobilityDisplay = true;
        break;

    }
  }
  getAccompanyingTypes(): any {
    return this.youngService.getAccompanyingTypes();
  }

  deleteMeeting(meetingIndex: number) {
    const meetings: Array<Meeting> = this.accompanying.meetings;
    this.accompanying.meetings.splice(meetingIndex, 1);
  }

  editMeeting(meetingIndex: number) {
    const modalRef = this.modalService.open(AddMeetingComponent);
    modalRef.componentInstance.setParentComponent(this);
    const currentMeeting = this.accompanying.meetings[meetingIndex];
    modalRef.componentInstance.setMeeting(currentMeeting);
  }

}
