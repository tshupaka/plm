import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  awarenessStatisticsURL = '/api/statistics/awarenesss';
  accompanyingStatisticsURL = '/api/statistics/accompanying';

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) { }

  getAccompanyingStatistics(years: any, geoFocus: any, foundings: any) {
    let parameters = "?";
    let yearsDefined = false;
    Object.entries(years).forEach(([key, value]) => {
      if (value) {
        parameters = parameters + "year=" + key + "&";
        yearsDefined = true;
      }
    });
    let geofocusDefined = false;
    Object.entries(geoFocus).forEach(([key, value]) => {
      if (value) {
        parameters = parameters + "geofocus=" + key + "&";
        geofocusDefined = true;
      }
    });
    let foundingsDefined = false;
    Object.entries(foundings).forEach(([key, value]) => {
      if (value) {
        parameters = parameters + "founding=" + key + "&";
        foundingsDefined = true;
      }
    });
    if (yearsDefined && geofocusDefined && foundingsDefined) {
      const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
      return this.http.get(this.accompanyingStatisticsURL + parameters, { 'headers': headers });
    } else {
      return new Observable();
    }
  }


  getAwarenessStatistics(years: any, geoFocus: any) {
    let parameters = "?";

    let yearsDefined = false;
    Object.entries(years).forEach(([key, value]) => {
      if (value) {
        parameters = parameters + "year=" + key + "&";
        yearsDefined = true;
      }
    });
    let geofocusDefined = false;
    Object.entries(geoFocus).forEach(([key, value]) => {
      if (value) {
        parameters = parameters + "geofocus=" + key + "&";
        geofocusDefined = true;
      }
    });
    if (yearsDefined && geofocusDefined) {
      const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
      return this.http.get(this.awarenessStatisticsURL + parameters, { 'headers': headers });
    } else {
      return new Observable();
    }
  }
}
