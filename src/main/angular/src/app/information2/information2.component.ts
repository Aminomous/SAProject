import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from '../models/personalInformation';
import { UserService } from '../user.service';
import { Education } from '../models/education';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-information2',
  templateUrl: './information2.component.html',
  styleUrls: ['./information2.component.css']
})
export class Information2Component implements OnInit {


  levels = ["ปริญญาโท/สูงกว่า", "ปริญญาตรี", "ปวท./ปวศ./อนุปริญญา", "ปวช./ม.ปลาย", "ม.ต้น", "ประถมศึกษา"]
  educations: Education[] = []
  pi: PersonalInformation = new PersonalInformation()
  constructor(private userService: UserService) {
    this.userService.personalInformation.subscribe((pi)=>{
      if (pi) {
        this.pi = pi
        if (pi.educations != null) {
          this.educations = pi.educations
          let tmp: Education[] = [];
          this.educations.forEach(el=>{
            if (!this.checkNullRow(el)) {
              tmp.push(el)
            }
          })
          this.pi.educations = tmp
          this.educations = tmp
        } else {
          this.pi.educations = this.educations
      }
      }
    })
  }

  ngOnInit() {
  }

  newRow() {
    this.educations.push(new Education())
  }

  checkNullRow(education) {
    return Object.keys(education).every(x => {
      return education[x]===''||education[x]===null
    });
  } 

  remove(edu) {
    const index: number = this.educations.indexOf(edu);
    if (index !== -1) {
        this.educations.splice(index, 1);
    }
  }

  print() {
    
  }

}
