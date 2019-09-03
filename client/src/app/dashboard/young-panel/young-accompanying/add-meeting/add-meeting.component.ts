import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { YoungAccompanyingComponent } from '../young-accompanying.component';
import { DropDownService } from 'src/app/service/drop-down.service';
import { Accompanying } from 'src/app/model/accompanying.model';
import { ProjectService } from 'src/app/service/project.service';
import { YoungService } from 'src/app/service/young.service';
import { NgForm } from '@angular/forms';
import { Meeting } from 'src/app/model/meeting.model';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'plm-add-meeting',
  templateUrl: './add-meeting.component.html',
  styleUrls: ['./add-meeting.component.css']
})
export class AddMeetingComponent implements OnInit {

  private youngAccompanyingComponent: YoungAccompanyingComponent;

  public meeting: Meeting;

  public dropDownValues: Object;

  public users: User[];



  constructor(private youngService: YoungService, private dropDownService: DropDownService,
    private userService: UserService, public activeModal: NgbActiveModal) { }


  ngOnInit() {
    this.initDropDownValue();
    this.meeting = new Meeting();
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});
    });
    this.userService.getAllUsers().subscribe(users => this.users = users);
  }


  setParentComponent(youngAccompanyingComponent: YoungAccompanyingComponent) {
    this.youngAccompanyingComponent = youngAccompanyingComponent;
  }


  saveMeeting(form: NgForm) {
    if (form.valid) {
      const userId = this.meeting.userId;
      // TODO voir comment gérer proprement les retour de liste déroulante
      this.meeting.user = this.getUserFromId(parseInt(userId.toString(), 10));

      this.youngAccompanyingComponent.handleAddMeeting(this.meeting);
      this.activeModal.dismiss();
    }
  }

  getUserFromId(userId: number): User {
    if (userId) {
      const selectedUsers = this.users.filter(user => user.id === userId);

      if (selectedUsers.length > 0) {
        return selectedUsers[0];
      }
    } return null;
  }

}
