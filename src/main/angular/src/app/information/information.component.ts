import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { PersonalInformation } from '../models/personalInformation';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit {

  pi: PersonalInformation
  page
  constructor(private router:Router, private userService: UserService) {
    this.pi = this.userService.personalInformation
    
  }

  ngOnInit() {
    let urls = this.router.url.split("/")
    
    if (urls[urls.length-1]=="") {
      this.page = 1
    } else {
      this.page = +urls[urls.length-1]
    }
  }

  save() {
    this.userService.updatePersonalInformation()
    this.router.navigate(['/'])
  }

  next() {
    this.page+=1
    this.router.navigate(['main','info',this.page])
  }

  previous() {
    this.page-=1
    this.router.navigate(['main','info',this.page])
  }

  cancel() {
    this.router.navigate([''])
  }

}
