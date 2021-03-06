import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { Project } from '../model/project.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {


  private urlProject = '/api/project/';


  private urlGetYoungByProjectId = '/api/project/:id/young';

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {}

  getAllProjects(): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.get(this.urlProject, { 'headers': headers });
  }

  getProjectById(id: any): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.get(this.urlProject + id, { 'headers': headers });
  }

  saveProject(project: Project): Observable<any> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.post(this.urlProject, project, { 'headers': headers });
}

getYoungsByProjectId(projectId: any): any {
  const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
  const url = this.urlGetYoungByProjectId.replace(':id', projectId.toString());
  return this.http.get(url, { 'headers': headers });
}
}
