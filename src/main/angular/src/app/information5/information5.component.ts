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

  pi: PersonalInformation
  constructor(private userService: UserService) {

    this.pi = new PersonalInformation()
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        
      }
    })
  }

  ngOnInit() {
  }
  print() {
    console.log(this.pi)
  }
}
