import { Component, OnInit } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { YoungService } from 'src/app/service/young.service';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';


import { Awareness } from 'src/app/model/awareness.model';
import { AwarenessService } from 'src/app/service/awareness.service';

@Component({
  selector: 'plm-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  ngOnInit(): void {

  }


}
