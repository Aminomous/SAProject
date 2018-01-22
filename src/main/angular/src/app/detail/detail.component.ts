import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';
import { Application } from 'app/models/application';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  piIsValid = false
  isDraft = false
  registrationStatus = "not sent"
  app:Application
  constructor(private userService: UserService) { 
    this.userService.getPersonalInformation().then(()=>{
      this.userService.getApplication().then(app=>{
        this.app = app;
        this.isDraft = this.app.applicationStatus6 == -1
        this.registrationStatus = this.app.applicationStatus6 == 0 ? "รอผลการสมัคร" : this.app.applicationStatus6 == 1 ? "ผ่าน" : "ไม่ผ่าน"
      })
    })
  }

  ngOnInit() {
  }

}
