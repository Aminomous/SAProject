import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';
import { Apprenticeship } from 'app/models/apprenticeship';

@Component({
  selector: 'app-application8',
  templateUrl: './application8.component.html',
  styleUrls: ['./application8.component.css']
})
export class Application8Component implements OnInit {

  numbers = []
  title = "ประวัติการอบรม, ดูงาน, ฝึกงาน (Job Training/ Inspection/ Apprenticeship)"
  application: Application
  
  constructor(private applicationService:ApplicationService) { 
    this.applicationService.getApplication().subscribe((application) => {
      this.application = application
      let i = 0
      application.apprenticeships.forEach(element => {
        this.numbers.splice(this.numbers.length, 0, i)
        i+=1
      });
    })
  }

  ngOnInit() {
  }

  addRow() {
    this.numbers.splice(this.numbers.length, 0, this.numbers.length)
    this.application.apprenticeships.splice(this.numbers.length, 0, new Apprenticeship())
  }

}
