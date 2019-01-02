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


@NgModule({
  imports: [
    CommonModule, FormsModule, NgbModule,
    RouterModule.forRoot([
      {
        path: 'dashboard', component: DashboardComponent,
        children: [
          { path: 'young/info', component: YoungPanelComponent },
          { path: 'awareness/info', component: AwarenessComponent }]
      }
    ]),
  ],
  declarations: [DashboardComponent,
    AwarenessComponent,
    YoungPanelComponent,
    YoungInformationsComponent,
    YoungFollowUpComponent,
    AddAwarenessComponent],
  entryComponents: [AddAwarenessComponent]
})
export class DashboardModule { }


