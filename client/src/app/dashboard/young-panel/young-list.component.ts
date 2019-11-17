import { Component, OnInit, Input, OnChanges, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { YoungService } from 'src/app/service/young.service';
import { Young } from 'src/app/model/young.model';
import { YoungFilter } from 'src/app/utils/bean/young-filter';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/model/user.model';
import { DropDownService } from 'src/app/service/drop-down.service';
import { isNgTemplate } from '@angular/compiler';

@Component({
  selector: 'plm-young-list',
  templateUrl: './young-list.component.html',
  styleUrls: ['./young-list.component.css']
})
export class YoungListComponent implements OnInit {


  @Input()
  public youngs: Young[];

  public youngFilter: YoungFilter;
  public accompanyingTypesMap: Map<number, string>;

  public dropDownValues: Object;


  accompanyingUsers: User[];
  accompanyingTypes: Array<any>;
  qpvStatusValues: any;

  constructor(private youngService: YoungService, private router: Router, private userService: UserService, private dropDownService: DropDownService) {
  }



  onFilterChange(event: any) {
    const youngFilterCopy = new YoungFilter();
    Object.assign(youngFilterCopy, this.youngFilter);
    this.youngFilter = youngFilterCopy;

    this.youngService.setYoungFilter(youngFilterCopy);
  }

  ngOnInit() {
    this.youngFilter = this.youngService.getYoungFilter();
    this.accompanyingTypes = this.youngService.getAccompanyingTypes();
    this.accompanyingTypesMap = new Map<number, string>();
    this.accompanyingTypes.forEach(type => this.accompanyingTypesMap.set(type.value, type.label));
    this.userService.getAllUsers().subscribe(users => this.accompanyingUsers = users);
    this.initDropDownValue();
  }


  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});

      this.qpvStatusValues = this.getDropDownValues('qpvStatus');
      console.log("QPVSStatus", this.qpvStatusValues[1].value);

    }
        
  );
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

getDropDownValue(key: string, id : number) {
  let values = this.getDropDownValues(key);
  let value;
  if (values) {
    values.forEach(item => {


      if (item.id == id) {
        value = item.value;

      }
    });
    return value;
  }
}


displayYoung(youngId: number) {
  this.router.navigate(['/dashboard/young', youngId]);
}

getAccompanyingTypeLabel(typeId: number) {
  return this.accompanyingTypesMap.get(typeId);
}

getAccompanyingTypes(): any {
  return this.accompanyingTypes;
}


isFilterEmpty(): boolean {
  return this.youngFilter.isEmpty();
}
}
