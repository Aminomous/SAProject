import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { UserService } from 'app/user.service';
import { ReferencePerson } from 'app/models/referencePerson';

@Component({
  selector: 'app-registration-form3',
  templateUrl: './registration-form3.component.html',
  styleUrls: ['./registration-form3.component.css']
})
export class RegistrationForm3Component implements OnInit {

  application: Application = new Application()
  ref1 = new ReferencePerson()
  ref2 = new ReferencePerson()
  constructor(private userService: UserService) { 
    this.userService.personalInformation.subscribe(()=>{
      this.userService.application.subscribe(app=>{
        this.application = app
        if (this.application.referencePeople.length > 0) {
          this.ref1 = this.application.referencePeople[0]
          if (this.application.referencePeople.length > 1) {
            this.ref1 = this.application.referencePeople[1]
          } else {
            // this.application.referencePeople.push(this.ref2)
          }
        } else {
          // this.application.referencePeople.push(this.ref1)
          // this.application.referencePeople.push(this.ref2)
        }
      })
    })
    
  }
  ngOnInit() {
  }

  change(n) {
    console.log(this.application)
    if (n) {
      let pos = this.application.referencePeople.indexOf(this.ref1)
      console.log(pos)
      if (this.checkNull(this.ref1.name) && this.checkNull(this.ref1.relationship) && this.checkNull(this.ref1.address) && this.checkNull(this.ref1.telephone) && this.checkTel(this.ref1.telephone)) {
        if (pos == -1) {
          this.application.referencePeople.push(this.ref1)
        }
      } else {
        if (pos != -1) {
          this.application.referencePeople.splice(pos, 1)
        }
      }
    } else {
      let pos = this.application.referencePeople.indexOf(this.ref2)
      console.log(pos)
      if (this.checkNull(this.ref2.name) && this.checkNull(this.ref2.relationship) && this.checkNull(this.ref2.address) && this.checkNull(this.ref2.telephone) && this.checkTel(this.ref2.telephone)) {
        if (pos == -1) {
          this.application.referencePeople.push(this.ref2)
        }
      } else {
        if (pos != -1) {
          this.application.referencePeople.splice(pos, 1)
        }
      }
    }
  }

  checkNull(field) {
    return (field != null) && (field != "")
  }

  checkTel(tel: string) {
    return tel.match(/0[0-9]{9}/g)
  }

}
