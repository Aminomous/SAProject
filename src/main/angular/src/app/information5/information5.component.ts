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
    this.userService.getPersonalInformation().then((pi)=>{
      this.pi = pi
      console.log(pi)
    })
  }
  
  
  
  ngOnInit() {
  }
  printOut(){
    console.log(this.pi.word)
  }
}
