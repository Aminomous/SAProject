import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { PersonalInformation } from '../models/personalInformation';

@Component({
  selector: 'app-information1',
  templateUrl: './information1.component.html',
  styleUrls: ['./information1.component.css']
})
export class Information1Component implements OnInit {

  prefixes = ["นาย", "นางสาว", "นาง"]
  pi: PersonalInformation
  constructor(private userService: UserService) { 
    this.pi = new PersonalInformation()
    console.log("info1")
    this.userService.getPersonalInformation().then((pi)=>{
      this.pi = pi
      console.log("info1 promise")
    })
  }

  ngOnInit() {
  }

}
