import { Component, OnInit, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddAwarenessComponent } from './add-awareness/add-awareness.component';
import { Young } from 'src/app/model/young.model';
import { YoungService } from 'src/app/service/young.service';
import { Awareness } from 'src/app/model/awareness.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'plm-young-awareness',
  templateUrl: './young-follow-up.component.html',
  styleUrls: ['./young-follow-up.component.css']
})
export class YoungFollowUpComponent implements OnInit {

  @Input()
  public young: Young;
  public awarenesses: Awareness[];

  constructor(private modalService: NgbModal, private youngService: YoungService) { }


  ngOnInit() {
    if (this.young && this.young.id) {
      this.youngService.getAwarenessFromYoung(this.young.id).subscribe((awarenesses: Awareness[]) => this.awarenesses = awarenesses);
    } else {
      this.awarenesses = new Array();
    }
  }

  handleAddAwareness(awarenessId: number) {
    const obs: Observable<Object> = this.youngService.addAwarenessToYoung(this.young.id, awarenessId);
    obs.subscribe((awareness: Awareness) => this.awarenesses.push(awareness));
    /*this.awarenesses.push(awareness);*/
  }

  addAwareness() {
    const modalRef = this.modalService.open(AddAwarenessComponent);
    modalRef.componentInstance.setParentComponent(this);
  }

  deleteAwareness(awarenessId: number) {
    this.youngService.deleteAwareness(this.young.id, awarenessId).subscribe(awarnesses => this.awarenesses = awarnesses);
  }

}
