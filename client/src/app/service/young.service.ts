import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Young } from '../model/young.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class YoungService {

  private urlCreateYoung = '/api/young';

  constructor(private http: HttpClient) { }



  saveYoung(young: Young): Observable<Object> {
    return this.http.post(this.urlCreateYoung, young);
  }
}
