import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Young } from '../model/young.model';
import { Observable } from 'rxjs';
import { Awareness } from '../model/awareness.model';
import { AuthenticationService } from './authentication.service';
import { Accompanying } from '../model/accompanying.model';

@Injectable({
  providedIn: 'root'
})
export class YoungService {


  private urlCreateYoung = '/api/young';
  private urlSearchYoung = '/api/youngs';
  private urlGetYoungById = '/api/young/';
  private urlGetAwarenesses = '/api/young/:id/awareness';
  private urlDeleteAwarenesses = '/api/young/:youngId/awareness/:awarenessId';
  private urlPostAwarnessAffectation = '/api/young/awareness';
  private urlGetAccompanyings: '/api/young/:id/accompanying';

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }


  saveYoung(young: Young): Observable<any> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.httpClient.post(this.urlCreateYoung, young, { 'headers': headers });
  }


  searchYoung(search: string): any {
    const params = new HttpParams().set('search', search);
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.httpClient.get(this.urlSearchYoung, { 'headers': headers, 'params': params });
  }

  getYoungById(id: number): any {

    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.httpClient.get(this.urlGetYoungById + id, { 'headers': headers });
  }

  getAwarenessFromYoung(id: number): Observable<Object> {

    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlGetAwarenesses.replace(':id', id.toString());
    return this.httpClient.get(url, { 'headers': headers });
  }

  addAwarenessToYoung(youngId: number, awarenessId: number): Observable<Object> {

    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const request: any = { 'youngId': youngId, 'awarenessId': awarenessId };
    return this.httpClient.post(this.urlPostAwarnessAffectation, request, { 'headers': headers });
  }

  deleteAwareness(youngId: number, awarenessId: number): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlDeleteAwarenesses.replace(':youngId', youngId.toString()).replace(':awarenessId', awarenessId.toString());
    return this.httpClient.delete(url, { 'headers': headers });
  }


  getAccompanyingsFromYoung(youngId: number): Observable<Object> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlGetAccompanyings.replace(':id', youngId.toString());
    return this.httpClient.get(url, { 'headers': headers });
  }

}
