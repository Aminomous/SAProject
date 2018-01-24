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
    let arr = [0, 1, 2]
    this.userService.personalInformation.subscribe(()=>{
      this.userService.application.subscribe(app=>{
        this.application = app
        for (let i = 0; i < this.application.qh1.length; i++) {
          let q = this.application.qh1[i]
          if (q.type == 0) {
            this.qh11 = q
            this.qh11checked = true
          } else if (q.type == 1) {
            this.qh12 = q
            this.qh12checked = true
          } else if (q.type == 2) {
            this.qh13 = q
            this.qh13checked = true
          }
        }
        
      })
    })
    
  }
  ngOnInit() {
  }
  select(c) {
    if (c == 0) {
      
      if (!this.qh11checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh11),1)
      } else {
        this.application.qh1.push(this.qh11)
      }
    }
    if (c == 1) {
      
      if (!this.qh12checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh12),1)
      } else {
        this.application.qh1.push(this.qh12)
      }
    }
    if (c == 2) {
      
      if (!this.qh13checked) {
        this.application.qh1.splice(this.application.qh1.indexOf(this.qh13),1)
      } else {
        this.application.qh1.push(this.qh13)
      }
    }
    
  }

}
