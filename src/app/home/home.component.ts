import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public userLoggedIn = false;
  private subscription: Subscription;

  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit(): void {
    /*this.subscription = this.authenticationService.getLoggedIn().subscribe(value => {
      this.userLoggedIn = value;
    });*/
  }

}
