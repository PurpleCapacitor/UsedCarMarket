import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { GraphQLModule } from './graphql.module';
import { LoginComponent } from './login/login.component';
import {RouterModule} from '@angular/router';
import { HomeComponent } from './home/home.component';
import {FormsModule} from '@angular/forms';
import { AdminComponent } from './admin/admin.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';
import { AdComponent } from './ad/ad.component';

const Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: HomeComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'ads', component: AdComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AdminComponent,
    RegistrationComponent,
    ProfileComponent,
    AdComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    GraphQLModule,
    RouterModule.forRoot(Routes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
