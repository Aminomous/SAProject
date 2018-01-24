import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';
import { Application } from 'app/models/application';
import { PersonalInformation } from 'app/models/personalInformation';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  piIsValid = false
  isDraft
  registrationStatus = "not sent"
  fail = false
  app:Application
  pi:PersonalInformation
  constructor(private userService: UserService) {
    this.userService.application.subscribe(app=>{
      if (app) {
        console.log(app)
        this.app = app;
        this.isDraft = this.app.applicationStatus6 == -1
        this.registrationStatus = this.app.applicationStatus6 == 0 ? "รอผลการสมัคร" : (this.app.applicationStatus6 == 1 ? "ผ่าน" : "ไม่ผ่าน")
        this.fail = this.app.applicationStatus6 == 2
      }
    })
    this.userService.personalInformation.subscribe(pi=>{
      this.pi = pi
    })
  }

  ngOnInit() {
  }

  newForm() {
    this.userService.addApplication(this.pi.citizenID)
    window.location.reload()
  }

}
