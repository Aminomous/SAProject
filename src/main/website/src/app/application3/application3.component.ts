import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';
import { Education } from 'app/models/education';

@Component({
  selector: 'app-application3',
  templateUrl: './application3.component.html',
  styleUrls: ['./application3.component.css']
})
export class Application3Component implements OnInit {
  numbers = []
  title = "ประวัติการศึกษา (Educational Background)"
  application: Application

  constructor(private applicationService:ApplicationService) { 
    this.applicationService.getApplication().subscribe((application) => {
      this.application = application
      let i = 0
      application.educations.forEach(element => {
        this.numbers.splice(this.numbers.length, 0, i)
        i+=1
      });
      console.log(this.numbers)
    })
  }
  
  ngOnInit() {
  }

  addRow() {
    this.numbers.splice(this.numbers.length, 0, this.numbers.length)
    this.application.educations.splice(this.numbers.length, 0, new Education())
  }

}
