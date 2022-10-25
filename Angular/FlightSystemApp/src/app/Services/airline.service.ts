import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = "http://localhost:8091/admin/students/"

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  createAirline(airline : {name:String, contactNumber:number, description:String}) {
    return this.http.post(BASE_URL, airline);
  }

  getAirlines() {
    return this.http.get(BASE_URL);
  }

  deleteAirline(airline:any) {
    return this.http.delete(BASE_URL + airline.id)
  }


  constructor(public http: HttpClient) { }
}
