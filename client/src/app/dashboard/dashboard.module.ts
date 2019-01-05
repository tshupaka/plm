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


@NgModule({
  imports: [
    CommonModule, FormsModule, NgbModule, ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: 'dashboard', component: DashboardComponent,
        children: [
          { path: 'home', component: HomeComponent },
          { path: 'young', component: YoungPanelComponent },
          { path: 'young/:id', component: YoungPanelComponent },
          { path: 'awareness', component: AwarenessComponent },
          { path: 'awareness/:id', component: AwarenessComponent }]
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
    AwarenessPipe],
  entryComponents: [AddAwarenessComponent]
})
export class DashboardModule { }


