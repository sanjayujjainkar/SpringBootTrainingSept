import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CaradminComponent } from './components/caradmin/caradmin.component';
import { CarbrokerComponent } from './components/carbroker/carbroker.component';
import { CarleaseComponent } from './components/carlease/carlease.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FlightadminComponent } from './components/flightadmin/flightadmin.component';
import { HttpClientModule } from '@angular/common/http';
import { AirlineComponent } from './components/airline/airline.component';
import { FlighcreateComponent } from './components/flighcreate/flighcreate.component';
import { FlightbookingComponent } from './components/flightbooking/flightbooking.component';

@NgModule({
  declarations: [
    AppComponent,
    CaradminComponent,
    CarbrokerComponent,
    CarleaseComponent,
    NavbarComponent,
    FlightadminComponent,
    AirlineComponent,
    FlighcreateComponent,
    FlightbookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
