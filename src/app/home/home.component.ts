import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Apollo, gql} from 'apollo-angular';
import {Router} from '@angular/router';

const searchAds = gql`
  query Ads($carModel: CarModelInput, $extras: ExtrasInput, $price: Int) {
  ads(carModel: $carModel, extras: $extras, price: $price) {
    price
    carModel {
      make
    }
  }

}`

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(
    private apollo: Apollo,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  placeAd(values: any) {

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
      make: values['make'],
      model: values['model'],
      year: values['year'].substring(0, 4),
      kilometers: Number(values['km'])
    };

    this.apollo.query({
      query: searchAds,
      variables: {
        carModel: carModel,
        extras: extras,
        price: Number(values['price'])
      }
    }).subscribe( ({data}) => {
      this.router.navigate(['/profile']);
    });

  }
}
