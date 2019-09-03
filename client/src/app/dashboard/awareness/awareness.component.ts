import { Component, OnInit } from '@angular/core';
import { Awareness } from '../../model/awareness.model';
import { NgForm } from '@angular/forms';
import { AwarenessService } from '../../service/awareness.service';
import { Route, ActivatedRoute } from '@angular/router';
import { DropDownService } from 'src/app/service/drop-down.service';
import { Observable, timer } from 'rxjs';
import { Young } from 'src/app/model/young.model';


@Component({
  selector: 'plm-awareness',
  templateUrl: './awareness.component.html',
  styleUrls: ['./awareness.component.css']
})
export class AwarenessComponent implements OnInit {

  public awareness: Awareness;
  private dropDownValues: Object;
  private errorMessage: String;
  private successMessage: String;

  private signatureRadioValue: string;
  private youngs: Young[];

  constructor(private dropDownService: DropDownService, private awarenessService: AwarenessService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.initDropDownValue();
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.awarenessService.getAwarenessById(id).subscribe((awareness: Awareness) => {
        this.awareness = awareness;
        if (awareness) {
          this.signatureRadioValue = awareness.signature ? 'true' : 'false';
        }
      });
      this.awarenessService.getYoungsByAwarenessId(id).subscribe((youngs: Young[]) => this.youngs = youngs);
    } else {
      this.awareness = new Awareness();
    }
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});
    });
  }

  getDropDownValues(key: string) {
    if (this.dropDownValues) {
      let values = this.dropDownValues[key];
      if (!values) {
        values = [];
      }
      return values;
    }
  }


  saveAwareness(form: NgForm) {
    if (form.valid) {
      this.awareness.signature = form.controls['signature'].value === 'true';
      this.awarenessService.saveAwarness(this.awareness).subscribe(awareness => {
        this.awareness = awareness;
        this.successMessage = 'Sensibilisation enregitrée avec succès.';
        timer(3000).subscribe(() => this.successMessage = undefined);
      });
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
      timer(3000).subscribe(() => this.errorMessage = undefined);
    }
  }

}
