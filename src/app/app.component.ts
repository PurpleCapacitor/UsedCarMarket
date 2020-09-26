import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';
import {AuthenticationService} from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ucmfront';
  public user = JSON.parse(localStorage.getItem('currentUser'));;
  public userLoggedIn = false;

  constructor(private apollo: Apollo,
              private authenticationService: AuthenticationService) {}

  ngOnInit(): void {
    this.authenticationService.login().subscribe(loggedIn => this.userLoggedIn = loggedIn);
  }

  logOut() {
    localStorage.removeItem("currentUser");
    this.authenticationService.login().subscribe(loggedIn => this.userLoggedIn = loggedIn);

  }
}
