import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';

@Component({
  selector: 'app-application2',
  templateUrl: './application2.component.html',
  styleUrls: ['./application2.component.css']
})
export class Application2Component implements OnInit {

  title = "ข้อมูลส่วนตัว (Personal Information)"

  application: Application

  constructor(private applicationService:ApplicationService) { 
    this.applicationService.getApplication().subscribe((application) => {
      this.application = application
      console.log(this.application)
    })
  }

  ngOnInit() {
  }

  print() {
    console.log(this.application)
  }
}
