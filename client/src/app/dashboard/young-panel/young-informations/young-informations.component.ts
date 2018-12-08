import { Component, OnInit } from '@angular/core';
import { Young } from '../../../model/young.model';
import { DropDownService } from '../../../service/drop-down.service';
import { NgForm } from '@angular/forms';
import { YoungService } from '../../../service/young.service';

@Component({
  selector: 'plm-young-informations',
  templateUrl: './young-informations.component.html',
  styleUrls: ['./young-informations.component.css']
})
export class YoungInformationsComponent implements OnInit {

  public young: Young = new Young();
  private dropDownValues: Object;
  private errorMessage: String;


  constructor(private dropDownService: DropDownService, private youngService: YoungService) { }

  ngOnInit() {
    this.initDropDownValue();
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe(dropDownValues => this.dropDownValues = dropDownValues);
  }


  getDropDownValues(key: string) {
    let values = this.dropDownValues[key];
    if (!values) {
      values = [];
    }
    return values;
  }

  saveYoung(form: NgForm) {
    if (form.valid) {
      this.youngService.saveYoung(this.young);
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
    }
  }
}
