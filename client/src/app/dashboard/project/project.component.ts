import { Component, OnInit } from '@angular/core';
import { DropDownService } from 'src/app/service/drop-down.service';
import { ActivatedRoute } from '@angular/router';
import { ProjectService } from 'src/app/service/project.service';
import { Project } from 'src/app/model/project.model';
import { NgForm } from '@angular/forms';
import { timer } from 'rxjs';

@Component({
  selector: 'plm-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {



  private dropDownValues: Object;
  private project: Project;
  private successMessage: string;
  private errorMessage: string;

  constructor(private dropDownService: DropDownService, private projectService: ProjectService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.initDropDownValue();
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.projectService.getProjectById(id).subscribe(project => this.project = project);
    } else {
      this.project = new Project();
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

  saveProject(form: NgForm) {
    console.log(form.valid);
    if (form.valid) {
      this.projectService.saveProject(this.project).subscribe(project => {
        this.project = project;
        this.successMessage = 'Projet enregitré avec succès.';
        timer(3000).subscribe(() => this.successMessage = undefined);
      });
    } else {
      this.errorMessage = 'Des erreurs ont été détecté dans le formulaire.';
      timer(3000).subscribe(() => this.errorMessage = undefined);
    }
  }
}
