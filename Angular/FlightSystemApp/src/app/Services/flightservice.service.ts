import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = "http://localhost:8091/admin"

@Injectable({
  providedIn: 'root'
})
export class FlightserviceService {

  createStudent(flight : {airline:String, source:String, destination:String, date:String}) {
    return this.http.post(BASE_URL+"/getFlights", flight);
  }

  getFlight() {
    return this.http.get(BASE_URL+"/getFlights");
  }

  deleteFlight(flight:any) {
    return this.http.delete(BASE_URL + flight.id)
  }

  constructor(public http: HttpClient) { }
}



