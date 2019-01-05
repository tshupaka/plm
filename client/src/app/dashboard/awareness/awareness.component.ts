import { Component, OnInit } from '@angular/core';
import { Awareness } from '../../model/awareness.model';
import { NgForm } from '@angular/forms';
import { AwarenessService } from '../../service/awareness.service';
import { Route, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'plm-awareness',
  templateUrl: './awareness.component.html',
  styleUrls: ['./awareness.component.css']
})
export class AwarenessComponent implements OnInit {

  public awareness: Awareness;
  private dropDownValues: Object;
  private errorMessage: String;

  constructor(private awarenessService: AwarenessService, private route: ActivatedRoute) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.awarenessService.getAwarenessById(id).subscribe(awareness => this.awareness = awareness);
    } else {
      this.awareness = new Awareness();
    }
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
      this.awarenessService.saveAwarness(this.awareness).subscribe(awareness => console.log(this.awareness));
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
    }
  }

}
