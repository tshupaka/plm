import { Component, OnInit } from '@angular/core';
import { Awareness } from '../../model/awareness.model';
import { NgForm } from '@angular/forms';
import { AwarenessService } from '../../service/awareness.service';
import { Route, ActivatedRoute } from '@angular/router';
import { DropDownService } from 'src/app/service/drop-down.service';
import { Observable, timer } from 'rxjs';


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

  constructor(private dropDownService: DropDownService, private awarenessService: AwarenessService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.initDropDownValue();
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.awarenessService.getAwarenessById(id).subscribe(awareness => this.awareness = awareness);
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
    console.log(form.valid);
    if (form.valid) {
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
