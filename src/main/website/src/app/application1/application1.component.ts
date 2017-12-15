import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';
import { Hospital } from 'app/models/hospital';

@Component({
  selector: 'app-application1',
  templateUrl: './application1.component.html',
  styleUrls: ['./application1.component.css']
})
export class Application1Component implements OnInit {


  hospitals: Hospital[] = [
    {
      hospitalName: "โรงพยาบาลพญาไท 1"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท 2"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท 3"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท นวมินทร์"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท ศรีราชา"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท พหลโยธิน"
    },
    {
      hospitalName: "โรงพยาบาลพญาไท สมุทรปราการ"
    },
    {
      hospitalName: "โรงพยาบาลเปาโล โชคชัย4"
    },
    {
      hospitalName: "โรงพยาบาลเปาโล รังสิต"
    },
    {
      hospitalName: "โรงพยาบาลเปาโล เกษตร"
    },
  ]
  title = "ความประสงค์ (Requirement)"

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

  chooseHospital(e, number) {
    if (e.target.checked) {
      this.application.hospitals.splice(0, 0, this.hospitals[number])
    } else {
      this.application.hospitals.splice(this.application.hospitals.indexOf(this.hospitals[number]), 1)
    }
  }

}
