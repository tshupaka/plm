import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddAwarenessComponent } from './add-awareness/add-awareness.component';

@Component({
  selector: 'plm-young-follow-up',
  templateUrl: './young-follow-up.component.html',
  styleUrls: ['./young-follow-up.component.css']
})
export class YoungFollowUpComponent implements OnInit {

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  addAwareness() {
    this.modalService.open(AddAwarenessComponent);
  }

}
