import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = "http://localhost:8091/admin"

@Injectable({
  providedIn: 'root'
})
export class FlightserviceService {

  createFlight(flight : {airline:String, source:String, destination:String, date:String}) {
    return this.http.post(BASE_URL+"/addFlight", flight);
  }

  getFlight() {
    return this.http.get(BASE_URL+"/getFlights");
  }

  deleteFlight(flight:any) {
    return this.http.delete(BASE_URL+"/deleteFlight/" + flight.id)
  }

  constructor(public http: HttpClient) { }
}



