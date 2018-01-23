import { Injectable } from '@angular/core';
import { User } from './models/user';
import { Http, Headers } from '@angular/http';
import { of } from 'rxjs/observable/of';
import { BehaviorSubject, Subject } from 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';
import { PersonalInformation } from './models/personalInformation';
import { Application } from './models/application';
import { ReplaySubject } from 'rxjs/ReplaySubject';

@Injectable()
export class UserService {

  headers: Headers = new Headers()
  private _personalInformation :PersonalInformation
  private _application: Application
  piSubject = new ReplaySubject<PersonalInformation>()
  appSubject = new ReplaySubject<Application>()
  loaded = false
  constructor(private http:Http) { }

  createUser(user) {
    return this.http.post("http://10.2.58.177/testauthapp/signup.php", JSON.stringify(user), {headers: this.headers})
  }

  // async loadPersonalInformation() {
  //   let email = localStorage.getItem('user')
  //   // 
  //   let res = await this.http.post("http://10.2.58.177/testauthapp/get_info.php", JSON.stringify(email), {headers: this.headers}).toPromise()
  //   this.personalInformation = JSON.parse(res.text())
  //   return this.personalInformation
  // }

  // async loadApplication() {
  //   let cid = this.personalInformation.citizenID
  //   
  //   let res = await this.http.post("http://10.2.58.177/testauthapp/get_app.php", JSON.stringify(cid), {headers: this.headers}).toPromise()
  //   this.application = JSON.parse(res.text())
  //   return this.application
  // }



  async loadData() {
    let email = localStorage.getItem('user')
    await this.http.post("http://10.2.58.177/testauthapp/get_info.php", JSON.stringify(email), {headers: this.headers}).subscribe(res => {
      this._personalInformation = JSON.parse(res.text())
      this.piSubject.next(this._personalInformation)
      
      let cid = this._personalInformation.citizenID
       this.http.post("http://10.2.58.177/testauthapp/get_app.php", JSON.stringify(cid), {headers: this.headers}).subscribe(res=>{
        this._application = JSON.parse(res.text())
        this.appSubject.next(this._application)
        
        this.loaded = true
      })
    })
  }







  get personalInformation() {
    
    // if (!this.loaded) {
    //   this.loadData()
    //   
    // }
    // return of(this._personalInformation)
    return this.piSubject
  }

  get application() {
    
    // if (!this.loaded) {
    //   this.loadData()
    //   
    // }
    return this.appSubject
  }

  updatePersonalInformation() {
    
    this.http.post("http://10.2.58.177/testauthapp/update_info.php", JSON.stringify(this.personalInformation), {headers: this.headers})
    .subscribe()
  }

  

  updateApplication(application) {
    
    
    this.http.post("http://10.2.58.177/testauthapp/update_app.php", JSON.stringify(application), {headers: this.headers})
    .subscribe()
  }

  checkPersonalInformation() {
    if (!this._personalInformation) return false
    return (this.checkNull(this._personalInformation.titleTH)) &&
      (this.checkNull(this._personalInformation.fNameTH)) &&
      (this.checkNull(this._personalInformation.lNameTH)) &&
      (this.checkNull(this._personalInformation.address)) &&
      (this.checkNull(this._personalInformation.telephone)) &&
      (this.checkNull(this._personalInformation.email)) &&
      (this.checkNull(this._personalInformation.dateOfBirth)) &&
      (this.checkNull(this._personalInformation.weight)) &&
      (this.checkNull(this._personalInformation.height)) &&
      (this.checkNull(this._personalInformation.placeOfBirth)) &&
      (this.checkNull(this._personalInformation.race)) &&
      (this.checkNull(this._personalInformation.nationality)) &&
      (this.checkNull(this._personalInformation.religion)) &&
      (this.checkNull(this._personalInformation.citizenID)) &&
      (this.checkNull(this._personalInformation.profNo)) &&
      (this.checkNull(this._personalInformation.militaryStatus)) &&
      (this.checkNull(this._personalInformation.maritalStatus))
  }

  private checkNull(field) {
    return field != "" && field != null
  }
}
