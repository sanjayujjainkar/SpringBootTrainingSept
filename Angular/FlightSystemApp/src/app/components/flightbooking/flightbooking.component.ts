import { Component, OnInit } from '@angular/core';
import Booking from 'src/app/entity/Booking';
import Flight from 'src/app/entity/Flight';
import FlightBookingDetail from 'src/app/entity/FlightBookingDetail';
import { FlightserviceService } from 'src/app/Services/flightservice.service';


@Component({
  selector: 'app-flightbooking',
  templateUrl: './flightbooking.component.html',
  styleUrls: ['./flightbooking.component.css']
})

export class FlightbookingComponent implements OnInit {

  booking: Booking = new Booking();
  bookingDetail: FlightBookingDetail = new FlightBookingDetail();
  selectedFlight: String = "";
  flights : String[] = []; 
  user: any = sessionStorage.getItem("USER");
  name : String = "Sanjay";


  save() {
    this.parseSelectedFlight();
    const observables = this.flightService.bookFlight(this.bookingDetail);
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

  parseSelectedFlight() {
    const array = this.booking.flight.split(":");
    this.bookingDetail.user = "Sanjay";
    this.bookingDetail.airline = array[0];
    this.bookingDetail.source = array[1];
    this.bookingDetail.destination = array[2];
    this.bookingDetail.date = array[3];
    this.bookingDetail.fare = parseInt(array[4]);
    this.bookingDetail.seatcount = this.booking.seats;
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
