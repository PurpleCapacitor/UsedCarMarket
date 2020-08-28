import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ucmfront';
  private book;



  constructor(private apollo: Apollo) {}

  ngOnInit(): void {
      this.apollo.watchQuery({
        query: gql`
        query testerino{
         ads {
          description
          user {
            username
          }
         }
        }
        `,
      })
        .valueChanges.subscribe(result => {
         this.book = result.data;
      });
  }
}
