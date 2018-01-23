import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { PersonalInformation } from '../models/personalInformation';
import { Application } from 'app/models/application';


@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  page
  application: Application
  constructor(private router:Router, private userService: UserService) {
    this.userService.personalInformation.subscribe(()=>{
      this.userService.application.subscribe(app=>{
        this.application = app
        
      })
    }) 
  }

  ngOnInit() {
    let urls = this.router.url.split("/")
    
    if (urls[urls.length-1]=="") {
      this.page = 1
    } else {
      this.page = +urls[urls.length-1]
    }
  }

  sent(){
    let now = new Date()
    let nowDate = now.getFullYear() + "-" + now.getMonth() + "-" + now.getDate()
    this.application.date = nowDate
    this.application.applicationStatus6 = 0
    this.userService.addPersonalInformation(this.application.refnum)
    this.save()
  }

  save() {
    this.userService.updateApplication(this.application)
    this.router.navigate(['/'])
  }

  next() {
    this.page+=1
    this.router.navigate(['main','registration',this.page])
  }

  previous() {
    this.page-=1
    this.router.navigate(['main','registration',this.page])
  }

  cancel() {
    this.router.navigate([''])
  }

}