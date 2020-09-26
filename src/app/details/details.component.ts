import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Apollo, gql} from 'apollo-angular';

const ad = gql`
    query Ad($id: Int!) {
        ad(id: $id) {
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
        }
    }
`

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  public result: any;

  constructor(private activatedRoute: ActivatedRoute, private apollo: Apollo) {
  }

  ngOnInit(): void {
    this.apollo.query({
      query: ad,
      variables: {
        id: this.activatedRoute.snapshot.url[1].path
      }
    }).subscribe(({data}) => {
      this.result = data["ad"];
    });
  }

}
