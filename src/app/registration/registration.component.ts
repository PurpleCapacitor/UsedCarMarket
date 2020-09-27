import { Component, OnInit } from '@angular/core';
import {Apollo, gql} from 'apollo-angular';
import {Router} from '@angular/router';


const userRegistration = gql`
  mutation UserRegistration($username: String!, $password: String!, $repeatedPassword: String!) {
    userRegistration(username: $username, password: $password, repeatedPassword: $repeatedPassword)
  }`;

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  constructor(
    private apollo: Apollo,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  register(values): void {
    this.apollo.mutate({
      mutation: userRegistration,
      variables: {
        username: values["username"],
        password: values["password"],
        repeatedPassword: values["repeatedPassword"]
      }
    }).subscribe(({data}) => {
      // @ts-ignore
      alert("Thank you for registering " + data.userRegistration);
      this.router.navigate(['/login']);
    }, error => {
      alert(error);
    });
  }
}
