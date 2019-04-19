import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { YoungService } from 'src/app/service/young.service';
import { Young } from 'src/app/model/young.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'plm-young-panel',
  templateUrl: './young-panel.component.html',
  styleUrls: ['./young-panel.component.css']
})
export class YoungPanelComponent implements OnInit {

  youngInformationActive: boolean;
  youngHistoryActive: boolean;
  youngHistoryEnable: boolean;
  youngAccompanyingActive: boolean;
  currentYoung: Young;

  constructor(private route: ActivatedRoute, private youngservice: YoungService) {
    this.youngInformationActive = true;
    this.youngHistoryActive = false;
    this.youngAccompanyingActive = false;
  }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.youngservice.getYoungById(id).subscribe(young => {
        this.currentYoung = young;
      });
    } else {
      this.currentYoung = new Young();
    }
  }


  setYoungInformationActive() {
    this.youngInformationActive = true;
    this.youngHistoryActive = false;
    this.youngAccompanyingActive = false;
  }

  setYoungHistoryActive() {
    this.youngHistoryActive = true;
    this.youngInformationActive = false;
    this.youngAccompanyingActive = false;
  }


  setYoungAccompanyingActive() {
    this.youngHistoryActive = false;
    this.youngInformationActive = false;
    this.youngAccompanyingActive = true;
  }

  saveYoung(young: Young) {
    console.log('saveYoung' + young);
    this.currentYoung = young;
  }

}
