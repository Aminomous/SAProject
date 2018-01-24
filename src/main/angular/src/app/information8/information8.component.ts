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

  news: Q6 = { mediaType: "news", detail: "" }
  website: Q6 = { mediaType: "website", detail: "" }
  conferrence: Q6 = { mediaType: "conferrence", detail: "" }
  suggested: Q6 = { mediaType: "suggested", detail: "" }
  other: Q6 = { mediaType: "other", detail: "" }
  q5ans
  constructor(private userService: UserService) {
    this.pi = new PersonalInformation();
    this.userService.personalInformation.subscribe((pi) => {
      if (pi) {
        this.pi = pi
        if (this.pi.q1 == null) this.pi.q1 = this.pi.q1 + ""
        if (this.pi.q2 == null) this.pi.q2 = this.pi.q2 + ""
        if (this.pi.q3 == null) this.pi.q3 = this.pi.q3 + ""
        if (this.pi.q4 == null) this.pi.q4 = this.pi.q4 + ""
        if (this.pi.q5 != null) {
          this.q5ans = "1"
        }

        // this.q6 = pi.q6;

        for (let i = 0; i < pi.q6.length; i++) {
          if (this.pi.q6[i].mediaType == "news") {
            // this.news.detail = this.q6[i].detail
            this.news = this.pi.q6[i]
          }
          else if (this.pi.q6[i].mediaType == "website") {
            // this.website.detail = this.pi.q6[i].detail
            this.website = this.pi.q6[i]

          }
          else if (this.pi.q6[i].mediaType == "conferrence") {
            // this.conferrence.detail = this.pi.q6[i].detail
            this.conferrence = this.pi.q6[i]
          }
          else if (this.pi.q6[i].mediaType == "suggested") {
            // this.suggested.detail = this.pi.q6[i].detail
            this.suggested = this.pi.q6[i]
          }
          else if (this.pi.q6[i].mediaType == "other") {
            // // this.other.detail = this.pi.q6[i].detail
            this.other = this.pi.q6[i]
          }
        }
        console.log(this.pi.q6);
        // this.q6 = []
        // if (this.news.detail != ""){
        //   this.q6.push(this.news)
        // }
        // if (this.website.detail != ""){
        //   this.q6.push(this.website)
        // }
        // if (this.conferrence.detail != ""){
        //   this.q6.push(this.conferrence)
        // }
        // if (this.suggested.detail != ""){
        //   this.q6.push(this.suggested)
        // }
        // if (this.other.detail != ""){
        //   this.q6.push(this.other)
        // }
      }
    })
  }

  ngOnInit() {
  }

  change(event) {
    let detail = event.target.value
    let type = event.target.id

    if (type == "news") {
      let pos = this.pi.q6.indexOf(this.news)
      if (detail != "") {
        if (pos == -1) {
          this.pi.q6.push(this.news)
        }
      } else if (detail == "") {
        if (pos != -1) {
          this.pi.q6.splice(pos, 1)
        }
      }
    }
    if (type == "website") {
      let pos = this.pi.q6.indexOf(this.website)
      if (detail != "") {
        if (pos == -1) {
          this.pi.q6.push(this.website)
        }
      } else if (detail == "") {
        if (pos != -1) {
          this.pi.q6.splice(pos, 1)
        }
      }
    }
    if (type == "conferrence") {
      let pos = this.pi.q6.indexOf(this.conferrence)
      if (detail != "") {
        if (pos == -1) {
          this.pi.q6.push(this.conferrence)
        }
      } else if (detail == "") {
        if (pos != -1) {
          this.pi.q6.splice(pos, 1)
        }
      }
    }
    if (type == "suggested") {
      let pos = this.pi.q6.indexOf(this.suggested)
      if (detail != "") {
        if (pos == -1) {
          this.pi.q6.push(this.suggested)
        }
      } else if (detail == "") {
        if (pos != -1) {
          this.pi.q6.splice(pos, 1)
        }
      }
    }
    if (type == "other") {
      let pos = this.pi.q6.indexOf(this.other)
      if (detail != "") {
        if (pos == -1) {
          this.pi.q6.push(this.other)
        }
      } else if (detail == "") {
        if (pos != -1) {
          this.pi.q6.splice(pos, 1)
        }
      }
    }
    console.log(this.pi.q6)
  }
  noq5() {
    this.pi.q5 = null
  }
}
