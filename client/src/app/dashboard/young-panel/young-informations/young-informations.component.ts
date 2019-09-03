import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Young } from '../../../model/young.model';
import { DropDownService } from '../../../service/drop-down.service';
import { NgForm } from '@angular/forms';
import { YoungService } from '../../../service/young.service';
import { Router } from '@angular/router';
import { timer } from 'rxjs';

@Component({
  selector: 'plm-young-informations',
  templateUrl: './young-informations.component.html',
  styleUrls: ['./young-informations.component.css']
})
export class YoungInformationsComponent implements OnInit {

  @Input()
  public young: Young;
  public dropDownValues: Object;
  public errorMessage: string;
  public successMessage: string;
  @Output()
  youngSaved: EventEmitter<Young> = new EventEmitter<Young>();



  constructor(private dropDownService: DropDownService, private youngService: YoungService, private router: Router) { }

  ngOnInit() {
    this.initDropDownValue();
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});
      console.log(this.dropDownValues);
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

  saveYoung(form: NgForm) {
    if (form.valid) {
      this.youngService.saveYoung(this.young).subscribe((young) => {
      this.young = young;
        this.youngSaved.emit(young);
        this.successMessage = 'Informations sauvegardées avec succès.';
        timer(3000).subscribe(() => this.successMessage = undefined);
      });
    } else {
      this.errorMessage = 'Des erreurs ont été détectées dans le formulaire.';
      timer(3000).subscribe(() => this.errorMessage = undefined);
    }
  }

}
