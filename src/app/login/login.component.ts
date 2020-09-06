import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../services/authentication.service';
import {Apollo, gql} from 'apollo-angular';
import {Router} from '@angular/router';

const userLogin = gql`
  mutation UserLogin($username: String!, $password: String!) {
    userLogin(username: $username, password: $password)  {
      username
      type
    }
  }`;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private user;
  private loggedIn = false;

  constructor(
    private apollo: Apollo,
    private router: Router,
    private authenticationService:AuthenticationService
  ) {}


  ngOnInit(): void {
  }

  login(values): void {
    console.log(values);
    this.apollo.mutate({
      mutation: userLogin,
      variables: {
        username: values["username"],
        password: values["password"]
      }
    }).subscribe(({data}) => {
      // @ts-ignore
      if(data.userLogin === null) {
        alert("Invalid login");
      } else {
        // @ts-ignore
        this.user = data.userLogin;
        localStorage.setItem("currentUser", JSON.stringify(this.user));
        this.authenticationService.login().subscribe(loggedIn => this.loggedIn = loggedIn);
        if(this.user.type === 'ADMIN') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/']);
        }
      }

    });
  }

}
