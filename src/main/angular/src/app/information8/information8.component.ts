import { Component, OnInit } from '@angular/core';
import { PersonalInformation } from 'app/models/personalInformation';
import { Q6 } from 'app/models/q6';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-information8',
  templateUrl: './information8.component.html',
  styleUrls: ['./information8.component.css']
})
export class Information8Component implements OnInit {
  
  pi: PersonalInformation
  q6: Q6[]
  
  news:Q6 = {mediaType:"news", detail:""}
  website:Q6 = {mediaType:"website", detail:""}
  conferrence:Q6 = {mediaType:"conferrence", detail:""}
  suggested:Q6 = {mediaType:"suggested", detail:""}
  other:Q6 = {mediaType:"other", detail:""}
  
  constructor(private userService: UserService) {
    this.pi = new PersonalInformation();
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        this.q6 = pi.q6;
        
        for (let i = 0 ; i < this.q6.length ; i++){
          this.news.detail = (this.q6[i].mediaType == "news")?this.q6[i].detail:"";
          this.website.detail = this.q6[i].mediaType == "website"?this.q6[i].detail:"";
          this.conferrence.detail = this.q6[i].mediaType == "conferrence"?this.q6[i].detail:"";
          this.suggested.detail = this.q6[i].mediaType == "suggested"?this.q6[i].detail:"";
          this.other.detail = this.q6[i].mediaType == "other"?this.q6[i].detail:"";
        }

        this.q6 = []
        
      }
    })
  }
  
  ngOnInit() {
  }
  
  change(event){
    let detail = event.target.value;
    if (detail == ""){
      const index = this.q6.indexOf(event.id)
    }
  }
}
