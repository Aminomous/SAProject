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
  pi: PersonalInformation = new PersonalInformation()
  app: Application = new Application()

  constructor(private router: Router, private authService: AuthService, private userService: UserService) {
    
    this.userService.loadData()
    
    this.userService.personalInformation.subscribe(pi => {
      
      if (pi) {
        this.pi = pi
        
        this.name = !this.pi ? "Anonymodawd us" : this.pi.fNameTH
        // this.name = !this.pi ? "Anonymous" : this.pi.fNameTH != "" ? this.pi.fNameTH : this.pi.fNameEN != "" ? this.pi.fNameEN : this.pi.email
      }
    })
    this.userService.application.subscribe(app => {
      if (app) this.app = app
    })

  }

  editPersonalInfo() {
    if (this.router.url.search("info") == -1) {
      this.router.navigate(['main', 'info'])
    }
  }


  ngOnInit() {
  }

  logout() {
    window.location.reload()
    this.authService.logout()
  }

}
