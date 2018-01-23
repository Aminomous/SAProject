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
    this.userService.getPersonalInformation().then(()=>{
      this.userService.getApplication().then(app=>{
        this.application = app
        console.log(app)
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
    this.application.applicationStatus6 = 0
    this.save()
  }

  save() {
    this.userService.updateApplication()
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