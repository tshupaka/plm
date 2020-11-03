import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard.component';
import { YoungPanelComponent } from './young-panel/young-panel.component';
import { YoungInformationsComponent } from './young-panel/young-informations/young-informations.component';
import { AwarenessComponent } from './awareness/awareness.component';
import { YoungFollowUpComponent } from './young-panel/young-follow-up/young-follow-up.component';
import { AddAwarenessComponent } from './young-panel/young-follow-up/add-awareness/add-awareness.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { AwarenessPipe } from '../utils/pipe/awareness.pipe';
import { SearchYoungComponent } from './young-panel/search-young.component';
import { SearchAwarenessComponent } from './awareness/search-awareness.component';
import { ParametersComponent } from './parameters/parameters.component';
import { DropdownParameterComponent } from './parameters/dropdown-parameter/dropdown-parameter.component';
import { UserParameterComponent } from './parameters/user-parameter/user-parameter.component';


import { DateValueAccessorDirective } from '../utils/date-value-accessor.directive';
import { AuthGuard } from '../guard/auth.guard';
import { YoungAccompanyingComponent } from './young-panel/young-accompanying/young-accompanying.component';
import { AddMeetingComponent } from './young-panel/young-accompanying/add-meeting/add-meeting.component';
import { ProjectComponent } from './project/project.component';
import { ProjectSearchComponent } from './project/project-search.component';
import { ProjectPipe } from '../utils/pipe/project.pipe';
import { YoungAccompanyingSummaryComponent } from './young-panel/young-accompanying/young-accompanying-summary.component';
import { YoungHistoricAccompanyingComponent } from './young-panel/young-accompanying/young-historic-accompanying.component';
import { YoungPopupClosedAccompanyingComponent } from './young-panel/young-accompanying/young-popup-closed-accompanying.component';
import { YoungPipe } from '../utils/pipe/young.pipe';
import { YoungListComponent } from './young-panel/young-list.component';
import { StatisticsComponent } from './statistics/statistics.component';
import { StatisticsDashboardComponent } from './statistics/statistics-dashboard.component';

@NgModule({
  imports: [
    CommonModule, FormsModule, NgbModule, ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard],
        children: [
          { path: 'home', component: HomeComponent },
          { path: 'young', component: YoungPanelComponent },
          { path: 'young/search', component: SearchYoungComponent },
          { path: 'young/:id', component: YoungPanelComponent },
          { path: 'awareness', component: AwarenessComponent },
          { path: 'awereness/search', component: SearchAwarenessComponent },
          { path: 'awareness/:id', component: AwarenessComponent },
          { path: 'project', component: ProjectComponent },
          { path: 'project/search', component: ProjectSearchComponent },
          { path: 'project/:id', component: ProjectComponent },
          { path: 'statistics', component: StatisticsComponent },
          { path: 'parameters/home', component: ParametersComponent },
          { path: 'parameters/dropdown', component: DropdownParameterComponent },
          { path: 'parameters/users', component: UserParameterComponent },
          { path: 'statistics/dashboard', component: StatisticsDashboardComponent}

        ]
      }
    ]),
  ],
  declarations: [DashboardComponent,
    AwarenessComponent,
    YoungPanelComponent,
    YoungInformationsComponent,
    YoungFollowUpComponent,
    AddAwarenessComponent,
    HomeComponent,
    AwarenessPipe,
    ProjectPipe,
    YoungPipe,
    SearchYoungComponent,
    SearchAwarenessComponent,
    ParametersComponent,
    DropdownParameterComponent,
    UserParameterComponent,
    DateValueAccessorDirective,
    AddMeetingComponent,
    ProjectComponent,
    ProjectSearchComponent,
    YoungAccompanyingSummaryComponent,
    YoungHistoricAccompanyingComponent,
    YoungAccompanyingComponent,
    YoungPopupClosedAccompanyingComponent,
    YoungListComponent,
    StatisticsComponent,
    StatisticsDashboardComponent
  ],
  entryComponents: [AddAwarenessComponent, AddMeetingComponent, YoungPopupClosedAccompanyingComponent]
})
export class DashboardModule { }


