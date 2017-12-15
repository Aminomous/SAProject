import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ApplicationService } from 'app/application.service';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {
  date: Date
  page: number
  constructor(private router: Router, private applicationService: ApplicationService) {
    this.applicationService.getApplication().subscribe((application) => {
      if (application == undefined) {
        this.cancel()
      }
    })
    let urls = this.router.url.split("/")
    urls = urls[urls.length-1].split(":")
    let p = urls[urls.length-1].replace(')', '')
    if (p == "") {
      this.page = 1
    } else {
      this.page = +p
    }
  }

  ngOnInit() {
  }

  back() {
    this.router.navigate(['/application', { outlets: { application: [this.page-1] }}]).then(() => {
      let urls = this.router.url.split("/")
      urls = urls[urls.length-1].split(":")
      let p = urls[urls.length-1].replace(')', '')
      if (p == "") {
        this.page = 1
      } else {
        this.page = +p
      }
    })
  }

  next() {
    this.router.navigate(['/application', { outlets: { application: [this.page+1] }}]).then(() => {
      let urls = this.router.url.split("/")
      urls = urls[urls.length-1].split(":")
      let p = urls[urls.length-1].replace(')', '')
      if (p == "") {
        this.page = 1
      } else {
        this.page = +p
      }
    })
  }

  cancel() {
    this.router.navigate(['/main'])
  }

  submit() {
  }

  isInvalidForm() : boolean {
    return true
  }

}
