import { Component, OnInit } from '@angular/core';
import Booking from 'src/app/entity/Booking';


@Component({
  selector: 'app-flightbooking',
  templateUrl: './flightbooking.component.html',
  styleUrls: ['./flightbooking.component.css']
})
export class FlightbookingComponent implements OnInit {

  bookings: Booking[] = [];


  deleteBooking(booking: any,index: number) {
   
  }

  constructor() { }

  ngOnInit(): void {
  }

}
