import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  loginURL = '/api/auth';
  token: string;

  constructor(private http: HttpClient) { }

  login(email: string, password: string, remember: boolean): Observable<any> {
    const request: any = { 'email': email, 'password': password };
    return this.http.post(this.loginURL, request, { observe: 'response' }).pipe(map((response: HttpResponse<any>) => {

      this.token = response.headers.get('Authorization');
      if (remember) {
        localStorage.setItem('token', this.token);
      }

    }), catchError((error: any) => throwError('Mot de passe ou identifiant invalide')));
  }


  getToken(): string {

    if (!this.token) {
      this.token = localStorage.getItem('token');
    }
    return this.token;
  }
}
