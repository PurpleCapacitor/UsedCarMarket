import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';

const getAds = gql`
  query UnapprovedAds {
    unapprovedAds {
      id
      description
      address
      phone
      price
      carModel {
        make
        model
        year
        displacement
        kilometers
        hp
      }
      user {
        username
      }
    }
  }
`;

const approve = gql`
    mutation ApproveAd($id: Int!) {
      approveAd(id: $id)
    }
`;

const disapprove = gql`
    mutation DeleteAd($id: Int!) {
      deleteAd(id: $id)
    }
`;

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public results = [];
  public ad: any;

  constructor(private apollo: Apollo) {
  }

  ngOnInit(): void {
    this.apollo.query({
      query: getAds
    }).subscribe(({data}) => {
      this.results = data['unapprovedAds'];
    });
  }

  viewAd(id: any) {
    for (let i of this.results) {
      if (i["id"] == id) {
        this.ad = i;
      }
    }
  }

  approve(id: any) {
    this.apollo.mutate({
      mutation: approve,
      variables: {
        id: id
      }
    }).subscribe(({data}) => {
      console.log("Approved successfully");
      location.reload();
    });

  }

  disapprove(id: any) {
    this.apollo.mutate({
      mutation: disapprove,
      variables: {
        id: id
      }
    }).subscribe(({data}) => {
      console.log("Deleted successfully");
      location.reload();
    });
  }

}
