import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';
import {AuthenticationService} from './services/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ucmfront';
  public user = JSON.parse(localStorage.getItem('currentUser'));
  public userLoggedIn = false;

  constructor(private apollo: Apollo,
              private authenticationService: AuthenticationService,
              private router: Router) {}

  ngOnInit(): void {
    this.authenticationService.loggedIn.subscribe(loggedIn => this.userLoggedIn = loggedIn);
  }

  logOut() {
    localStorage.removeItem("currentUser");
    this.authenticationService.loggedIn.next(false);
    this.router.navigate(['/']);

  }
}
