import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from '../models/personalInformation';
import { UserService } from '../user.service';
import { LanguageAbility } from 'app/models/languageAbility';

@Component({
  selector: 'app-information4',
  templateUrl: './information4.component.html',
  styleUrls: ['./information4.component.css']
})
export class Information4Component implements OnInit {

  pi: PersonalInformation = new PersonalInformation()
  langs: LanguageAbility[] = []
  constructor(private userService: UserService) { 
    this.langs.push(new LanguageAbility())
    this.langs.push(new LanguageAbility())
    this.langs.push(new LanguageAbility())
    this.langs[0].language = "ไทย"
    this.langs[1].language = "English"
    this.userService.getPersonalInformation().then((pi)=>{
      this.pi = pi
      if (this.pi.languageAbilities == null) {
        this.pi.languageAbilities = this.langs
      } else {
        if (this.pi.languageAbilities[0] == null) {
          this.pi.languageAbilities[0] = this.langs[0]
        }
        if (this.pi.languageAbilities[1] == null) {
          this.pi.languageAbilities[1] = this.langs[1]
        }
        if (this.pi.languageAbilities[2] == null) {
          this.pi.languageAbilities[2] = new LanguageAbility()
        }
        this.langs = this.pi.languageAbilities
      }
    })
  }

  ngOnInit() {
  }

}
