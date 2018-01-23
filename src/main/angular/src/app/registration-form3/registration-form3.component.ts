import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-registration-form3',
  templateUrl: './registration-form3.component.html',
  styleUrls: ['./registration-form3.component.css']
})
export class RegistrationForm3Component implements OnInit {

  application: Application = new Application()
  constructor(private userService: UserService) { 
    this.userService.getPersonalInformation().then(()=>{
      this.userService.getApplication().then(app=>{
        this.application = app
        console.log(app)
      })
    })
    
  }
  ngOnInit() {
  }

}
