import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Apollo, gql} from 'apollo-angular';
import {Router} from '@angular/router';

const searchAds = gql`
  query Ads($carModel: CarModelInput, $extras: ExtrasInput, $price: Int) {
  ads(carModel: $carModel, extras: $extras, price: $price) {
    id
    price
    carModel {
      make
      model
      year
    }
  }

}`

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public results = [];


  constructor(
    private apollo: Apollo,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  placeAd(values: any) {

    let make = null;
    let model = null;
    let year = null;

    if(values['make'] !== '') {
      make = values['make'];
    }

    if(values['model'] !== '') {
      model = values['model'];
    }

    if(values['year'] !== '') {
      year = values['year'].substring(0, 4);
    }

    let extras = {
      cruiseControl: values['cruiseControl'],
      electricalMirrors: values['electricalMirrors'],
      electricalSeats: values['electricalSeats'],
      electricalWindows: values['electricalWindows'],
      multifunctionalSteeringWheel: values['multifunctionalSteeringWheel'],
      bluetooth: values['bluetooth'],
      ledHeadlights: values['ledHeadlights'],
      heatedSeats: values['heatedSeats']
    };
    let carModel = {
      make: make,
      model: model,
      year: year,
      kilometers: Number(values['km'])
    };

    this.apollo.query({
      query: searchAds,
      variables: {
        carModel: carModel,
        extras: extras,
        price: Number(values['price'])
      }
    }).subscribe(({data}) => {
      this.results = data['ads'];
    });

  }

  viewAd(id: any) {
    this.router.navigate(['/ads/' + id]);

  }
}
