import { Component, OnInit } from '@angular/core';
import Airline from 'src/app/entity/Airline';
import Flight from 'src/app/entity/Flight';
import { AirlineService } from 'src/app/Services/airline.service';
import { FlightserviceService } from 'src/app/Services/flightservice.service';

@Component({
  selector: 'app-flightadmin',
  templateUrl: './flightadmin.component.html',
  styleUrls: ['./flightadmin.component.css']
})

export class FlightadminComponent implements OnInit {

  airline: Airline = new Airline();
  flights: Flight[] = [];

  deleteFlight() {

  }
  
  // save() {
  //   const observables = this.airlineService.createAirline(this.airline)
  //   observables.subscribe(
  //     (response: any) => {
  //       console.log(response);
  //     },
  //     function (error) {
  //       console.log(error);
  //       alert('Something went wrong try again!');
  //     }
  //   );
  // }

  //constructor(public airlineService: AirlineService) { }

  constructor(public flighService: FlightserviceService) { }

  ngOnInit(): void {

    const promise = this.flighService.getFlight();
     promise.subscribe((response) => {
       console.log(response);
       this.flights = response as Flight[];
     })

  }

}


// import { Component, OnInit } from '@angular/core';
// import Student from 'src/app/entity/Student';
// import { StudentsService } from 'src/app/Services/students.service';

// @Component({
//   selector: 'app-student-registration',
//   templateUrl: './student-registration.component.html',
//   styleUrls: ['./student-registration.component.css']
// })
// export class StudentRegistrationComponent implements OnInit {
//   students: Student[] = [];

//   deleteStudent(student, index) {
//     const observable = this.studentService.deleteStudent(student);
//     observable.subscribe((response:any) => {
//       console.log(response);
//       this.students.splice(index, 1)
//     })
//   }

//   constructor(private studentService: StudentsService)  { }

//   ngOnInit(): void {
//     const promise = this.studentService.getStudent();
//     promise.subscribe((response) => {
//       console.log(response);
//       this.students = response as Student[];
//     })

//   }

// }

