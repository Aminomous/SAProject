import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';
import { PersonalInformation } from '../models/personalInformation';
import { Application } from '../models/application';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  name = "Anonymous"
  pi: PersonalInformation
  app: Application

  constructor(private router:Router, private authService: AuthService, private userService: UserService) {
    this.loadData()

  }

  async loadData() {
    this.pi = await this.userService.loadPersonalInformation()
    // console.log(this.pi)
    this.name = this.pi.fNameTH != "" ? this.pi.fNameTH : this.pi.fNameEN != "" ? this.pi.fNameEN : this.pi.email
    this.app = await this.userService.loadApplication()
    // console.log(this.app)
  }

  editPersonalInfo() {
    if (this.router.url.search("info") == -1) {
      this.router.navigate(['main','info'])
    }
  }


  ngOnInit() {
  }

  logout() {
    this.authService.logout()
  }

}
