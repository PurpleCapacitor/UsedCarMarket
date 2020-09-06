import { Injectable } from '@angular/core';
import {BehaviorSubject, observable, Observable, Subject, of} from 'rxjs';
import {rewriteURIForGET} from '@apollo/client';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public loggedIn = new Subject();

  login(): Observable<boolean> {
    if(localStorage.getItem("currentUser") !== null) {
      this.loggedIn.next(true);
      return of(true);
    } else {
      this.loggedIn.next(false);
      return of(false);
    }
  }

  logout(): boolean {
    this.loggedIn.next(false);
    return false;
  }
}
