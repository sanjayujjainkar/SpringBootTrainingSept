import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  name:String="";
  age:number=0;
  title = 'AngularFirstProject';
  desc:String = "This is my first angular project";

  save() {
    console.log("The username:"+this.name + " whos age is:"+this.age);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
