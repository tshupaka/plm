import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard.component';
import { YoungPanelComponent } from './young-panel/young-panel.component';
import { YoungInformationsComponent } from './young-panel/young-informations/young-informations.component';


@NgModule({
  imports: [
    CommonModule, FormsModule,
    RouterModule.forRoot( [
      {path: 'young/info', component: YoungPanelComponent},
    ]),
  ],
  declarations: [DashboardComponent, YoungPanelComponent, YoungInformationsComponent]
})
export class DashboardModule { }


