import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CaradminComponent } from './components/caradmin/caradmin.component';
import { CarbrokerComponent } from './components/carbroker/carbroker.component';
import { CarleaseComponent } from './components/carlease/carlease.component';
import { FlightadminComponent } from './components/flightadmin/flightadmin.component';

const routes: Routes = [{path:"caradmin", component:CaradminComponent}
,{path:"carbroker", component:CarbrokerComponent}
,{path:"carlease", component:CarleaseComponent}
,{path:"flightadmin", component:FlightadminComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
