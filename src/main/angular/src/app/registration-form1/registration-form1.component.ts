import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';
import { Application } from 'app/models/application';

@Component({
  selector: 'app-registration-form1',
  templateUrl: './registration-form1.component.html',
  styleUrls: ['./registration-form1.component.css']
})
export class RegistrationForm1Component implements OnInit {


  application: Application = new Application()
  constructor(private userService: UserService) { 
    this.userService.personalInformation.subscribe(()=>{
      this.userService.application.subscribe(app=>{
        this.application = app
        
      })
    })
  }

  ngOnInit() {
  }

  selectHospital(hos){

    
    let i = this.application.hospitals.indexOf(hos)
    if (i==-1) {
      this.application.hospitals.push(hos)
    } else {
      this.application.hospitals.splice(i,1)
    }
  }

}
