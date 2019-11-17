import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Young } from '../model/young.model';
import { Observable } from 'rxjs';
import { Awareness } from '../model/awareness.model';
import { AuthenticationService } from './authentication.service';
import { Accompanying } from '../model/accompanying.model';
import { YoungFilter } from '../utils/bean/young-filter';

@Injectable({
  providedIn: 'root'
})
export class YoungService {



  private urlCreateYoung = '/api/young';
  private urlDeleteYoung = '/api/young/:id';
  private urlSearchYoung = '/api/youngs';
  private urlGetYoungById = '/api/young/';
  private urlGetAwarenesses = '/api/young/:id/awareness';
  private urlDeleteAwarenesses = '/api/young/:youngId/awareness/:awarenessId';
  private urlPostAwarnessAffectation = '/api/young/awareness';
  private urlGetCurrentAccompanying = '/api/young/:id/accompanying/current';
  private urlGetHistoricAccompanyings = '/api/young/:id/accompanying/historic';
  private urlPostAccompanying = '/api/young/:id/accompanying';
  private urlGetAccompanyingById = '/api/young/accompanying/:id';
  private youngFilter: any;

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }


  saveYoung(young: Young,  forceInsert:boolean): Observable<any> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());

    return this.httpClient.post(this.urlCreateYoung + '?force=' + forceInsert, young, { 'headers': headers,   observe: 'response'  });
  }


  getAllYoungs(): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.httpClient.get(this.urlSearchYoung, { 'headers': headers });
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


  getCurrentAccompanyingFromYoung(youngId: number): Observable<Object> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlGetCurrentAccompanying.replace(':id', youngId.toString());
    return this.httpClient.get(url, { 'headers': headers });
  }

  getHistoricAccompanyingsFromYoung(youngId: number): Observable<Object> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlGetHistoricAccompanyings.replace(':id', youngId.toString());
    return this.httpClient.get(url, { 'headers': headers });
  }


  getAccompanyingById(accompanyingId: number): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlGetAccompanyingById.replace(':id', accompanyingId.toString());
    return this.httpClient.get(url, { 'headers': headers });
  }


  saveAccompanying(youngId: number, accompanying: Accompanying): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlPostAccompanying.replace(':id', youngId.toString());
    return this.httpClient.post(url, accompanying, { 'headers': headers });
  }

  deleteYoung(youngId: number): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.urlDeleteYoung.replace(':id', youngId.toString());
    return this.httpClient.delete(url, { 'headers': headers });
  }

  getYoungFilter(): YoungFilter {
    if (!this.youngFilter) {
      this.youngFilter = new YoungFilter();
    }
    return this.youngFilter;
  }

  setYoungFilter(youngFilter: YoungFilter) {
    this.youngFilter = youngFilter;
  }




  getAccompanyingTypes(): Array<any> {
    return [
      { 'value': 1, 'label': 'Abandon' },
      { 'value': 2, 'label': 'Sortie Positive' },
      { 'value': 3, 'label': 'Premier entretien' },
      { 'value': 4, 'label': 'Accompagnement avant départ' },
      { 'value': 5, 'label': 'Mobilité' },
      { 'value': 6, 'label': 'Accompagnement au retour' },
      { 'value': 7, 'label': 'Fin de suivi' }];
  }
}
