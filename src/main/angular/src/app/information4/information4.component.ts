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
  noThirdLang = true
  constructor(private userService: UserService) {
    this.langs.push(new LanguageAbility())
    this.langs.push(new LanguageAbility())
    this.langs.push(new LanguageAbility())
    this.langs[0].language = "ไทย"
    this.langs[1].language = "English"
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        if (this.pi.languageAbilities == null) {
          this.pi.languageAbilities = this.langs
        } else {
          if (this.pi.languageAbilities[0] != null) {
            this.langs[0] = this.pi.languageAbilities[0]
          } else {
            this.pi.languageAbilities.push(this.langs[0])
          }
          if (this.pi.languageAbilities[1] != null) {
            this.langs[1] = this.pi.languageAbilities[1]
          } else {
            this.pi.languageAbilities.push(this.langs[1])
          }
          if (this.pi.languageAbilities[2] != null) {
            this.langs[2] = this.pi.languageAbilities[2]
          }
        }
      }
    })
  }

  ngOnInit() {
  }
  checkThirdLang(){
    console.log(this.pi.languageAbilities)
    let pos = this.pi.languageAbilities.indexOf(this.langs[2])
    if (this.langs[2].language!="") {
      this.noThirdLang = false
      if (pos == -1) {
        this.pi.languageAbilities.push(this.langs[2])
      }
    } else {
      this.noThirdLang = true
      if (pos != -1) {
        this.pi.languageAbilities.splice(pos, 1)
      }
    }
  }

}
