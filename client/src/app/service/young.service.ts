import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Young } from '../model/young.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class YoungService {



  private urlCreateYoung = '/api/young';
  private urlSearchYoung = '/api/youngs';
  private urlGetYoungById = '/api/young/';

  constructor(private httpClient: HttpClient) { }



  saveYoung(young: Young): Observable<Object> {
    return this.httpClient.post(this.urlCreateYoung, young);
  }


  searchYoung(search: string): any {
    const params = new HttpParams().set('search', search);
    return this.httpClient.get(this.urlSearchYoung, { params: params });
  }

  getYoungById(id: number): any {
    return this.httpClient.get(this.urlGetYoungById + id);
  }


}
