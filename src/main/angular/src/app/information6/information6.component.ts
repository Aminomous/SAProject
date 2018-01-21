import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from '../models/personalInformation';
import { UserService } from '../user.service';
import { Apprenticeship } from '../models/apprenticeship';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-information6',
  templateUrl: './information6.component.html',
  styleUrls: ['./information6.component.css']
})
export class Information6Component implements OnInit {

  levels = ["ปริญญาโท/สูงกว่า", "ปริญญาตรี", "ปวท./ปวศ./อนุปริญญา", "ปวช./ม.ปลาย", "ม.ต้น", "ประถมศึกษา"]
  apprenticeships: Apprenticeship[] = []
  pi: PersonalInformation = new PersonalInformation()
  constructor(private userService: UserService) {
    this.userService.getPersonalInformation().then((pi)=>{
      this.pi = pi
      if (pi.educations != null) {
        this.apprenticeships = pi.apprenticeships
        let tmp: Apprenticeship[] = [];
        this.apprenticeships.forEach(el=>{
          if (!this.checkNullRow(el)) {
            tmp.push(el)
          }
        })
        this.pi.apprenticeships = tmp
        this.apprenticeships = tmp
      } else {
        this.pi.apprenticeships = this.apprenticeships
      }
    })
  }

  ngOnInit() {
  }

  newRow() {
    this.apprenticeships.push(new Apprenticeship())
  }

  checkNullRow(education) {
    return Object.keys(education).every(x => {
      return education[x]===''||education[x]===null
    });
  } 

  remove(edu) {
    const index: number = this.apprenticeships.indexOf(edu);
    if (index !== -1) {
        this.apprenticeships.splice(index, 1);
    }
  }

  print() {
    console.log(this.pi)
  }
}
