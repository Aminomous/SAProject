import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';
import { Application } from 'app/models/application';
import { Hospital } from 'app/models/hospital';

@Component({
  selector: 'app-registration-form1',
  templateUrl: './registration-form1.component.html',
  styleUrls: ['./registration-form1.component.css']
})
export class RegistrationForm1Component implements OnInit {


  application: Application = new Application()
  hospitals = [
    {hospital: new Hospital("โรงพยาบาลพญาไท 1"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท 2"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท 3"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท นวมินทร์"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท ศรีราชา"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท พหลโยธิน"), selected: false},
    {hospital: new Hospital("โรงพยาบาลพญาไท สมุทรปราการ"), selected: false},
    {hospital: new Hospital("โรงพยาบาลเปาโล โชคชัย 4"), selected: false},
    {hospital: new Hospital("โรงพยาบาลเปาโล รังสิต"), selected: false},
    {hospital: new Hospital("โรงพยาบาลเปาโล เกษตร"), selected: false}
  ]
  


  constructor(private userService: UserService) { 
    this.userService.personalInformation.subscribe(()=>{
      this.userService.application.subscribe(app=>{
        this.application = app
        for (let hos of this.application.hospitals) {
          let name = hos.hospitalName
          for (let hos2 of this.hospitals) {
            if (hos2.hospital.hospitalName == name) {
              hos2.selected = true
              break
            }
          }
        }
      })
    })
  }

  ngOnInit() {
  }

  selectHospital(hosNo){
    console.log(this.application)
    if (this.hospitals[hosNo].selected) {
      this.application.hospitals.push(this.hospitals[hosNo].hospital)
    } else {
      let name = this.hospitals[hosNo].hospital.hospitalName
      let index = 0
      for (let hos of this.application.hospitals) {
        if (hos.hospitalName == name) {
          break
        }
        index += 1
      }
      this.application.hospitals.splice(index, 1)
    }
  }

}
