import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from '../models/personalInformation';
import { UserService } from '../user.service';
import { FamilyDetail } from '../models/familyDetail';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-information7',
  templateUrl: './information7.component.html',
  styleUrls: ['./information7.component.css']
})
export class Information7Component implements OnInit {

  familyDetails: FamilyDetail[] = []
  pi: PersonalInformation = new PersonalInformation()
  constructor(private userService: UserService) {
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        if (pi.educations != null) {
          this.familyDetails = pi.familyDetails
          let tmp: FamilyDetail[] = [];
          this.familyDetails.forEach(el => {
            if (!this.checkNullRow(el)) {
              tmp.push(el)
            }
          })
          this.pi.familyDetails = tmp
          this.familyDetails = tmp
        } else {
          this.pi.familyDetails = this.familyDetails
        }
      }
    })
  }

  ngOnInit() {
  }

  newRow() {
    this.familyDetails.push(new FamilyDetail())
  }

  checkNullRow(education) {
    return Object.keys(education).every(x => {
      return education[x] === '' || education[x] === null
    });
  }

  remove(edu) {
    const index: number = this.familyDetails.indexOf(edu);
    if (index !== -1) {
      this.familyDetails.splice(index, 1);
    }
  }

  print() {
    
  }
}
