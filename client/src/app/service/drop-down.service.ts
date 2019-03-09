import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class DropDownService {


  dropDownUrl = '/api/dropdowns';

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {
  }

  getDropDownValues() {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.get(this.dropDownUrl, { 'headers': headers });
  }


  addDropdownValue(key: String, value: String, order: number): Observable<any> {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const request: any = { 'key': key, 'value': value, 'order': order };

    return this.http.post(this.dropDownUrl, request, { 'headers': headers });
  }

  deleteValue(id: number): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const url = this.dropDownUrl + '/' + id;
    return this.http.delete(url, { 'headers': headers });
  }
}
