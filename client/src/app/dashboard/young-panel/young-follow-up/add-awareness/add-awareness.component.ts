import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Awareness } from 'src/app/model/awareness.model';
import { AwarenessService } from 'src/app/service/awareness.service';

@Component({
  selector: 'plm-add-awareness',
  templateUrl: './add-awareness.component.html',
  styleUrls: ['./add-awareness.component.css']
})
export class AddAwarenessComponent implements OnInit {

  awarenesses: Awareness[];

  constructor(private awarenessService: AwarenessService, private activeModal: NgbActiveModal) { }

  ngOnInit() {
    this.awarenessService.getAllAwarenesses().subscribe((awarenesses: Awareness[]) => this.awarenesses = awarenesses);

  }

  addAwareness(awarenessId: number) {
    console.log(awarenessId);
  }

}
