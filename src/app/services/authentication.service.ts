import { Injectable } from '@angular/core';
import {BehaviorSubject, observable, Observable, Subject, of} from 'rxjs';
import {rewriteURIForGET} from '@apollo/client';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public loggedIn = new Subject<boolean>();

  login() {
    if(localStorage.getItem("currentUser") !== null) {
      this.loggedIn.next(true);
    } else {
      this.loggedIn.next(false);
    }
  }

  logout(): boolean {
    this.loggedIn.next(false);
    return false;
  }
}
