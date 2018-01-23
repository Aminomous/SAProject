import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from 'app/models/personalInformation';
import { LanguageAbility } from 'app/models/languageAbility';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-information5',
  templateUrl: './information5.component.html',
  styleUrls: ['./information5.component.css']
})
export class Information5Component implements OnInit {
  haveCarLC = "0"
  haveBikeLC = "0"
  pi: PersonalInformation
  constructor(private userService: UserService) {

    this.pi = new PersonalInformation()
    
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        
        this.pi.driveCar = this.pi.driveCar + "";
        this.pi.ownCar = this.pi.ownCar + "";
        this.pi.rideMotocycle = this.pi.rideMotocycle +"";
        this.pi.ownMotocycle = this.pi.ownMotocycle + "";
        console.log(this.pi.driveLicenseCar)
        if (this.pi.driveLicenseCar == null) {
          this.haveCarLC = "0"
        } else {
          this.haveCarLC = "1"
        }
        if (this.pi.driveLicenseMotocycle == null) {
          this.haveBikeLC = "0"
        } else {
          this.haveBikeLC = "1"
        }
      }
    })
  }

  ngOnInit() {
  }
  noLC(type) {
    if (type == 'car') {
      this.pi.driveLicenseCar = null
    } else {
      this.pi.driveLicenseMotocycle = null
    }
  }
}
