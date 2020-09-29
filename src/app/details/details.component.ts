import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Apollo, gql} from 'apollo-angular';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';

const ad = gql`
    query Ad($id: Int!) {
        ad(id: $id) {
          description
          address
          phone
          price
          image {
            name
          }
          carModel {
            make
            model
            year
            displacement
            kilometers
            hp
          }
          extras {
            cruiseControl
            electricalMirrors
            electricalSeats
            electricalWindows
            multifunctionalSteeringWheel
            bluetooth
            ledHeadlights
            heatedSeats
          }
          condition {
            firstOwner
            serviceHistory
            spareKey
            taxi
          }
          characteristics {
            emissionClass
            ac
            drivetrain
            color
            registeredUntil
          }
          safety {
            ABS
            ESP
            airbags
            centralLocking
            childLock
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
  public imageSrc: any;
  private readonly imageType : string = 'data:image/PNG;base64,';

  constructor(private activatedRoute: ActivatedRoute,
              private apollo: Apollo,
              private httpClient: HttpClient,
              private sanitization:DomSanitizer) {
  }

  ngOnInit(): void {
    this.apollo.query({
      query: ad,
      variables: {
        id: this.activatedRoute.snapshot.url[1].path
      }
    }).subscribe(({data}) => {
      this.result = data["ad"];
      this.httpClient.get('http://localhost:8080/image/' + this.result.image.name)
        .subscribe(
          res => {
            this.imageSrc = this.sanitization.bypassSecurityTrustUrl(this.imageType + res["content"]);
          }
        );
    });
  }

}
