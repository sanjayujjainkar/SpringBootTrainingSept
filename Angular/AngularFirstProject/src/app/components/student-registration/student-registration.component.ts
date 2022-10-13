import { Component, OnInit } from '@angular/core';
import Student from 'src/app/entity/Student';
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {
  students: Student[] = [];

  deleteStudent(student, index) {
    const observable = this.studentService.deleteStudent(student);
    observable.subscribe((response:any) => {
      console.log(response);
      this.students.splice(index, 1)
    })
  }

  constructor(private studentService: StudentsService)  { }

  ngOnInit(): void {
    const promise = this.studentService.getStudent();
    promise.subscribe((response) => {
      console.log(response);
      this.students = response as Student[];
    })

  }

}
