import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Apollo, gql} from 'apollo-angular';
import {AuthenticationService} from '../services/authentication.service';

const userAds = gql`
    query UserAds($username: String!) {
      userAds(username: $username) {
        id
        price
        carModel {
          make
          model
          year
        }
        characteristics {
            color
        }
      }
    }
`

const deleteAd = gql`
    mutation DeleteAd($id: Int!) {
      deleteAd(id: $id)
    }
`

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public ads = [];
  private user = JSON.parse(localStorage.getItem('currentUser'));

  constructor(
    private router: Router,
    private apollo: Apollo
  ) { }

  ngOnInit(): void {
    this.fetchData()
  }

  newAd() {
    this.router.navigate(['/ads']);
  }

  deleteAd(id) {
    this.apollo.mutate({
      mutation: deleteAd,
      variables: {
        id: id
      }
    }).subscribe(({data}) => {
      this.fetchData()
    });
  }

  fetchData() {
    this.apollo.mutate({
      mutation: userAds,
      variables: {
        username: this.user.username
      }
    }).subscribe( ({data}) => {
      this.ads = data['userAds'];
    });
  }
}
