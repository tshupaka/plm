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
import { AwarenessPipe } from './home/awareness.pipe';
import { SearchYoungComponent } from './young-panel/search-young.component';
import { SearchAwarenessComponent } from './awareness/search-awareness.component';
import { ParametersComponent } from './parameters/parameters.component';
import { DropdownParameterComponent } from './parameters/dropdown-parameter/dropdown-parameter.component';
import { UserParameterComponent } from './parameters/user-parameter/user-parameter.component';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DateValueAccessorDirective } from '../utils/date-value-accessor.directive';
import { AuthGuard } from '../guard/auth.guard';

@NgModule({
  imports: [
    CommonModule, FormsModule, NgbModule, ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: 'dashboard', component: DashboardComponent,  canActivate: [AuthGuard],
        children: [
          { path: 'home', component: HomeComponent },
          { path: 'young', component: YoungPanelComponent },
          { path: 'young/search', component: SearchYoungComponent },
          { path: 'young/:id', component: YoungPanelComponent },
          { path: 'awareness', component: AwarenessComponent },
          { path: 'awereness/search', component: SearchAwarenessComponent },
          { path: 'awareness/:id', component: AwarenessComponent },
          { path: 'parameters/home', component: ParametersComponent },
          { path: 'parameters/dropdown', component: DropdownParameterComponent },
          { path: 'parameters/users', component: UserParameterComponent }
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
    SearchYoungComponent,
    SearchAwarenessComponent,
    ParametersComponent,
    DropdownParameterComponent,
    UserParameterComponent,
    DateValueAccessorDirective
  ],
  entryComponents: [AddAwarenessComponent]
})
export class DashboardModule { }


