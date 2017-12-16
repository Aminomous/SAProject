import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';
import { EmploymentRecord } from 'app/models/employmentRecord';

@Component({
  selector: 'app-application5',
  templateUrl: './application5.component.html',
  styleUrls: ['./application5.component.css']
})
export class Application5Component implements OnInit {
  numbers = []
  title = "ประวัติการทำงาน (Employment Record)"
  application: Application
  
  constructor(private applicationService:ApplicationService) { 
    this.applicationService.getApplication().subscribe((application) => {
      this.application = application
      let i = 0
      application.employmentRecords.forEach(element => {
        this.numbers.splice(this.numbers.length, 0, i)
        i+=1
      });
    })
  }

  ngOnInit() {
  }

  addRow() {
    this.numbers.splice(this.numbers.length, 0, this.numbers.length)
    this.application.employmentRecords.splice(this.numbers.length, 0, new EmploymentRecord())
  }

}
