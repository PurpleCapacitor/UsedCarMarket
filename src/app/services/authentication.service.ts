import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private userLoggedIn = new BehaviorSubject(false);

  getLoggedIn(): Observable<boolean> {
    return this.userLoggedIn.asObservable();
  }

  getLoggedInValue(): boolean {
    return this.userLoggedIn.getValue();
  }

  setLoggedIn(val: boolean): void {
    this.userLoggedIn.next(val);
  }
}
