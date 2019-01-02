import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'plm-young-panel',
  templateUrl: './young-panel.component.html',
  styleUrls: ['./young-panel.component.css']
})
export class YoungPanelComponent implements OnInit {

  youngInformationActive: boolean;
  youngHistoryActive: boolean;

  constructor() {
    this.youngInformationActive = false;
    this.youngHistoryActive = true;
  }

  ngOnInit() {
  }


  setYoungInformationActive() {
    this.youngInformationActive = true;
    this.youngHistoryActive = false;
  }

setYoungHistoryActive() {
  this.youngHistoryActive = true;
  this.youngInformationActive = false;
}

}
