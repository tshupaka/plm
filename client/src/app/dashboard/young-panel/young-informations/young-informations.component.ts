import { Component, OnInit, Input } from '@angular/core';
import { Young } from '../../../model/young.model';
import { DropDownService } from '../../../service/drop-down.service';
import { NgForm } from '@angular/forms';
import { YoungService } from '../../../service/young.service';
import { Router } from '@angular/router';

@Component({
  selector: 'plm-young-informations',
  templateUrl: './young-informations.component.html',
  styleUrls: ['./young-informations.component.css']
})
export class YoungInformationsComponent implements OnInit {

  @Input()
  public young: Young;
  private dropDownValues: Object;
  private errorMessage: String;


  constructor(private dropDownService: DropDownService, private youngService: YoungService, private router: Router ) { }

  ngOnInit() {
    this.initDropDownValue();
    console.log(this.young);
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe(dropDownValues => this.dropDownValues = dropDownValues);
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

  saveYoung(form: NgForm) {
    console.log(form.valid);
    if (form.valid) {
      this.youngService.saveYoung(this.young).subscribe(young => console.log(young));
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
    }
  }


  cancel() {
    this.router.navigate(['/dashboard/home']);
  }
}
