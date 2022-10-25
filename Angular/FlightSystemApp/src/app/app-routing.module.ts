import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlineComponent } from './components/airline/airline.component';
import { CaradminComponent } from './components/caradmin/caradmin.component';
import { CarbrokerComponent } from './components/carbroker/carbroker.component';
import { CarleaseComponent } from './components/carlease/carlease.component';
import { FlighcreateComponent } from './components/flighcreate/flighcreate.component';
import { FlightadminComponent } from './components/flightadmin/flightadmin.component';
import Airline from './entity/Airline';

const routes: Routes = [
{path:"carbroker", component:CarbrokerComponent},
{path:"carlease", component:CarleaseComponent},
{path:"airline", component:AirlineComponent},
{path:"flightcreate", component:FlighcreateComponent},
{path:"flightadmin", component:FlightadminComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
