import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/service/project.service';
import { Router } from '@angular/router';
import { Project } from 'src/app/model/project.model';

@Component({
  selector: 'plm-project-search',
  templateUrl: './project-search.component.html',
  styleUrls: ['./project-search.component.css']
})
export class ProjectSearchComponent implements OnInit {

  public projects: Project[];
  public projectSearch: string;

  constructor(private projectService: ProjectService, private router: Router) { }

  ngOnInit() {
    this.projectService.getAllProjects().subscribe((projects: Project[]) => this.projects = projects);

  }



  displayProject(projectId: number) {
    this.router.navigate(['/dashboard/project', projectId]);
  }

  addProject() {
    this.router.navigate(['/dashboard/project']);
  }
}
