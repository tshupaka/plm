import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Awareness } from '../model/awareness.model';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AwarenessService {

    private urlCreateAwareness = '/api/awareness';

    private urlGetAllAwarenesses = '/api/awareness/all';

    constructor(private httpClient: HttpClient) {

    }

    saveAwarness(awareness: Awareness): Observable<Object> {
        return this.httpClient.post(this.urlCreateAwareness, awareness);
    }

    getAllAwarenesses(): Observable<Object> {
        return this.httpClient.get(this.urlGetAllAwarenesses);
    }
}
