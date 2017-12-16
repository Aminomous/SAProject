import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';

@Component({
  selector: 'app-application4',
  templateUrl: './application4.component.html',
  styleUrls: ['./application4.component.css']
})
export class Application4Component implements OnInit {

  title = "ประวัติการศึกษา (Educational Background)"
  application: Application
  
    constructor(private applicationService:ApplicationService) { 
      this.applicationService.getApplication().subscribe((application) => {
        this.application = application
      })
    }

  ngOnInit() {
  }

}
