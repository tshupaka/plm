import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DropDownService {
  dropDownUrl = '/api/dropdowns';

  constructor(private http: HttpClient) {

  }

  getDropDownValues() {

    return this.http.get(this.dropDownUrl);
  }
}
