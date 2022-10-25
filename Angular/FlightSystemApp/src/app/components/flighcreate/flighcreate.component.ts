import { Component, OnInit } from '@angular/core';
import Flight from 'src/app/entity/Flight';
import { FlightserviceService } from 'src/app/Services/flightservice.service';

@Component({
  selector: 'app-flighcreate',
  templateUrl: './flighcreate.component.html',
  styleUrls: ['./flighcreate.component.css']
})
export class FlighcreateComponent implements OnInit {

  flight : Flight = new Flight();
  name : String = "Sanjay";


  save() {
    const observables = this.flightService.createFlight(this.flight);
    observables.subscribe(
      (response: any) => {
        console.log(response);
      },
      function (error) {
        console.log(error);
        alert('Something went wrong try again!');
      }
    );
  }

  constructor(public flightService: FlightserviceService) {}

  ngOnInit(): void {
  }

}
