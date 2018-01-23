import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from '../models/personalInformation';
import { UserService } from '../user.service';
import { EmploymentRecord } from '../models/employmentRecord';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-information3',
  templateUrl: './information3.component.html',
  styleUrls: ['./information3.component.css']
})
export class Information3Component implements OnInit {

  employmentRecords: EmploymentRecord[] = []
  pi: PersonalInformation = new PersonalInformation()
  constructor(private userService: UserService) {
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        if (pi.educations != null) {
          this.employmentRecords = pi.employmentRecords
          let tmp: EmploymentRecord[] = [];
          this.employmentRecords.forEach(el => {
            if (!this.checkNullRow(el)) {
              tmp.push(el)
            }
          })
          this.pi.employmentRecords = tmp
          this.employmentRecords = tmp
        } else {
          this.pi.employmentRecords = this.employmentRecords
        }
      }
    })
  }

  ngOnInit() {
  }

  newRow() {
    this.employmentRecords.push(new EmploymentRecord())
  }

  checkNullRow(education) {
    return Object.keys(education).every(x => {
      return education[x] === '' || education[x] === null
    });
  }

  remove(edu) {
    const index: number = this.employmentRecords.indexOf(edu);
    if (index !== -1) {
      this.employmentRecords.splice(index, 1);
    }
  }

  print() {
    
  }
}
