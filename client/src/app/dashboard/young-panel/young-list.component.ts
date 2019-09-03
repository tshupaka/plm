import { Component, OnInit, Input, OnChanges, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { YoungService } from 'src/app/service/young.service';
import { Young } from 'src/app/model/young.model';
import { YoungFilter } from 'src/app/utils/bean/young-filter';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/model/user.model';

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


  accompanyingUsers: User[];
  accompanyingTypes: Array<any>;

  constructor(private youngService: YoungService, private router: Router, private userService: UserService) {
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
}
