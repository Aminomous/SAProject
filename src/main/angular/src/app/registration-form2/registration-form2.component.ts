import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { UserService } from 'app/user.service';
import { QH1 } from 'app/models/qh1';

@Component({
  selector: 'app-registration-form2',
  templateUrl: './registration-form2.component.html',
  styleUrls: ['./registration-form2.component.css']
})
export class RegistrationForm2Component implements OnInit {

  application: Application = new Application()
  qh11checked = false
  qh12checked = false
  qh13checked = false
  qh11 = new QH1()
  qh12 = new QH1()
  qh13 = new QH1()
  constructor(private userService: UserService) { 
    this.qh11.type = 0
    this.qh12.type = 1
    this.qh13.type = 2
    this.userService.getPersonalInformation().then(()=>{
      this.userService.getApplication().then(app=>{
        this.application = app
        console.log(app)
      })
    })
    
  }
  ngOnInit() {
  }
  select(c) {
    if (c == 0) {
      console.log(c)
      if (this.qh11checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh11),1)
      } else {
        this.application.qh1.push(this.qh11)
      }
      this.qh11checked = !this.qh11checked
    }
    if (c == 1) {
      console.log(c)
      if (this.qh12checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh12),1)
      } else {
        this.application.qh1.push(this.qh12)
      }
      this.qh12checked = !this.qh12checked
    }
    if (c == 2) {
      console.log(c)
      if (this.qh13checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh13),1)
      } else {
        this.application.qh1.push(this.qh13)
      }
      this.qh13checked = !this.qh13checked
    }
    console.log(this.application)
  }

}
