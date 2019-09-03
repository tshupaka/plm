import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Awareness } from '../model/awareness.model';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
    providedIn: 'root'
})
export class AwarenessService {



    private urlCreateAwareness = '/api/awareness';

    private urlGetAllAwarenesses = '/api/awareness/all';
    private urlGetAwarenessById = '/api/awareness/';

    private urlGetYoungByAwarenessId = '/api/awareness/:id/young';

    constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) {
    }

    saveAwarness(awareness: Awareness): Observable<any> {
        const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
        return this.httpClient.post(this.urlCreateAwareness, awareness, { 'headers': headers });
    }

    getAllAwarenesses(): Observable<Object> {
        const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
        return this.httpClient.get(this.urlGetAllAwarenesses, { 'headers': headers });
    }

    getAwarenessById(id: number): any {
        const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
        return this.httpClient.get(this.urlGetAwarenessById + id, { 'headers': headers });
    }

    getYoungsByAwarenessId(awarenessId: number): any {
        const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
        const url = this.urlGetYoungByAwarenessId.replace(':id', awarenessId.toString());
        return this.httpClient.get(url, { 'headers': headers });
      }
}
