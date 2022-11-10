import { Component, OnInit } from '@angular/core';
import Booking from 'src/app/entity/Booking';
import Flight from 'src/app/entity/Flight';
import { FlightserviceService } from 'src/app/Services/flightservice.service';


@Component({
  selector: 'app-flightbooking',
  templateUrl: './flightbooking.component.html',
  styleUrls: ['./flightbooking.component.css']
})

export class FlightbookingComponent implements OnInit {

  booking: Booking = new Booking();
  selectedFlight: String = "";
  //flights : Flight[] = []; //String[] = []; 
  flights : String[] = []; 
  
  name : String = "Sanjay";


  save() {
    // const observables = this.flightService.bookFlight(this.flight);
    // observables.subscribe(
    //   (response: any) => {
    //     console.log(response);
    //   },
    //   function (error) {
    //     console.log(error);
    //     alert('Something went wrong try again!');
    //   }
    // );
    console.log("selected Flight:"+this.selectedFlight);
    alert("selected Flight:"+this.selectedFlight)
  }

  allFlights() {
    
  }

  deleteBooking(booking: any,index: number) {
   
  }

  ngOnInit(): void {
    //const promise = this.flightService.getFlight(); //getFlightsAsStringList()
    const promise = this.flightService.getFlightsAsStringList()
    promise.subscribe((response) => {
      console.log(response);
      //this.flights = response as Flight[]; //String[];
      this.flights = response as String[];
    })
  }

  constructor(public flightService: FlightserviceService) {}

}
