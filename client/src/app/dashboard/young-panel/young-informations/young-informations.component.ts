import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Young } from '../../../model/young.model';
import { DropDownService } from '../../../service/drop-down.service';
import { NgForm } from '@angular/forms';
import { YoungService } from '../../../service/young.service';
import { Router } from '@angular/router';
import { timer } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

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


  public deleteCurrentYoungInProgress = false;

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
      /*this.youngService.saveYoung(this.young).subscribe((young) => {
        this.young = young;
        this.youngSaved.emit(young);
        this.successMessage = 'Informations sauvegardées avec succès.';
        timer(3000).subscribe(() => this.successMessage = undefined);
        });
        */
      this.saveYoungInternal(this.young, false)


    } else {
      this.errorMessage = 'Des erreurs ont été détectées dans le formulaire.';
      timer(3000).subscribe(() => this.errorMessage = undefined);
    }
  }

  saveYoungInternal(young: Young, forceInsert: boolean) {
    this.youngService.saveYoung(this.young, forceInsert).subscribe((response: HttpResponse<any>) => {
      let responseCode = response.status;
      let body = response.body;
      console.log("Erreur", response);
      if (responseCode === 200) {
        this.young = body;
        this.youngSaved.emit(young);
        this.successMessage = 'Informations sauvegardées avec succès.';
        timer(3000).subscribe(() => this.successMessage = undefined);
      } else if (responseCode === 208) {
        let young = body;
        if (confirm('Un jeune possédant le même nom est déjà enregistré : ' + young.lastname + ' ' + young.firstname  + '\nEtes-vous sûr de vouloir insérer ce jeune ?')) {
          this.saveYoungInternal(this.young, true);
        }
      } else {
        this.errorMessage = 'Erreur lors de l\'enregistrement du formulaire';
        timer(3000).subscribe(() => this.errorMessage = undefined);
      }

    });
  }

  deleteCurrentYoung() {
    this.deleteCurrentYoungInProgress = true;
    if (confirm('Êtes-vous sûr de vouloir supprimer ce jeune et tous les accompagnements associés ?')) {
      this.youngService.deleteYoung(this.young.id).subscribe(() => {
        this.deleteCurrentYoungInProgress = false;
        this.router.navigate(['/dashboard/young/search']);
      });
    } else {
      this.deleteCurrentYoungInProgress = false;
    }
  }

}
