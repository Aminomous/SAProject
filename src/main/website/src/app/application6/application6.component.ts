import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';

@Component({
  selector: 'app-application6',
  templateUrl: './application6.component.html',
  styleUrls: ['./application6.component.css']
})
export class Application6Component implements OnInit {

  title = "ความสามารถทางภาษา (Language Ability)"
  application: Application
  
  constructor(private applicationService:ApplicationService) { 
    this.applicationService.getApplication().subscribe((application) => {
      this.application = application
      console.log(this.application)
    })
  }
  ngOnInit() {
  }

}
