import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { map, catchError } from 'rxjs/operators';
import { User } from '../model/user.model';
import { throwError, ObservableInput } from 'rxjs';
import { ArrayType } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class UserService {



  userURL = '/api/user';

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) { }


  getAllUsers(): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.get(this.userURL, { 'headers': headers });
  }


  saveUser(user: User): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    return this.http.post(this.userURL, user, { 'headers': headers }).pipe(
      map((users) => users)
      , catchError(this.handleError));
  }

  deleteUser(user: User): any {
    const headers = new HttpHeaders().set('authorization', this.authenticationService.getToken());
    const deleteUrl = this.userURL + '/' + user.id;
    return this.http.delete(deleteUrl,  { 'headers': headers });
  }


  handleError(error: HttpErrorResponse): ObservableInput<{}> {
    let errorMessage = 'Erreur serveur, veuillez essayez ultérieurmenent';
    if (error.status === 422) {
      errorMessage = 'L\'adresse email est déjà utilisée.';
    }
    if (error.status === 400) {
      errorMessage = 'Veuillez saisir un nom et un email';
    }
    return throwError(errorMessage);

  }


}
