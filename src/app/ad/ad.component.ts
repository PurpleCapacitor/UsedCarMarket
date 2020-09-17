import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';
import {Router} from '@angular/router';
import {ConsoleLogger} from '@angular/compiler-cli/ngcc';


const placeAd = gql`
  mutation PlaceAd($input: AdsInput, $carModel: CarModelInput,
    $user: UserInput,
    $extras: ExtrasInput,
    $condition: ConditionInput,
    $characteristics: CharacteristicsInput
    $safety: SafetyInput) {
    placeAd(input: $input, user: $user, extras: $extras, carModel: $carModel,
      condition: $condition, characteristics: $characteristics, safety: $safety) {
      id
    }
  }
`;

@Component({
  selector: 'app-ad',
  templateUrl: './ad.component.html',
  styleUrls: ['./ad.component.css']
})
export class AdComponent implements OnInit {

  private user = JSON.parse(localStorage.getItem('currentUser'));

  constructor(
    private apollo: Apollo,
    private router: Router
  ) {
  }

  ngOnInit(): void {
  }

  placeAd(values: any) {
    let input = {
      description: values['description'],
      address: values['address'],
      phone: values['phone'],
      price: values['price']
    };
    let user = {
      username: this.user.username
    };
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
      kilometers: values['km'],
      displacement: values['displacement'],
      hp: values['hp']
    };
    let condition = {
      firstOwner: values['firstOwner'],
      serviceHistory: values['serviceHistory'],
      spareKey: values['spareKey'],
      taxi: values['taxi']
    };
    let characteristics = {
      emissionClass: values['emissionClass'],
      ac: values['ac'],
      drivetrain: values['drivetrain'],
      color: values['color'],
      registeredUntil: values['registeredUntil']
    };
    let safety = {
      ABS: values['abs'],
      ESP: values['esp'],
      airbags: values['airbags'],
      centralLocking: values['centralLocking'],
      childLock: values['childLock']
    };

    this.apollo.mutate({
      mutation: placeAd,
      variables: {
        input: input,
        user: user,
        carModel: carModel,
        extras: extras,
        condition: condition,
        characteristics: characteristics,
        safety: safety
      }
    }).subscribe( ({data}) => {
      this.router.navigate(['/profile']);
    })
  }
}
