import { Injectable } from '@angular/core';
import { User } from './models/user';
import { Http, Headers } from '@angular/http';
import { of } from 'rxjs/observable/of';
import { PersonalInformation } from './models/personalInformation';
import { Application } from './models/application';

@Injectable()
export class UserService {

  headers: Headers = new Headers()
  personalInformation :PersonalInformation
  application: Application

  constructor(private http:Http) { }

  createUser(user) {
    return this.http.post("http://localhost/testauthapp/signup.php", JSON.stringify(user), {headers: this.headers})
  }

  async loadPersonalInformation() {
    let email = localStorage.getItem('user')
    // console.log(email)
    let res = await this.http.post("http://localhost/testauthapp/get_info.php", JSON.stringify(email), {headers: this.headers}).toPromise()
    this.personalInformation = JSON.parse(res.text())
    return this.personalInformation
  }

  async loadApplication() {
    let cid = this.personalInformation.citizenID
    // console.log(cid)
    let res = await this.http.post("http://localhost/testauthapp/get_app.php", JSON.stringify(cid), {headers: this.headers}).toPromise()
    this.application = JSON.parse(res.text())
    return this.application
  }

  async getPersonalInformation() {
    if (this.personalInformation == null) {
      await this.loadPersonalInformation()
    }
    return this.personalInformation
  }

  async getApplication() {
    if (this.application == null) {
      await this.loadApplication()
    }
    return this.application
  }

  updatePersonalInformation() {
    console.log(this.personalInformation)
    this.http.post("http://localhost/testauthapp/update_info.php", JSON.stringify(this.personalInformation), {headers: this.headers})
    .subscribe()
  }

  checkPersonalInformation() {
    return (this.checkNull(this.personalInformation.titleTH)) &&
      (this.checkNull(this.personalInformation.fNameTH)) &&
      (this.checkNull(this.personalInformation.lNameTH)) &&
      (this.checkNull(this.personalInformation.address)) &&
      (this.checkNull(this.personalInformation.phoneNumber)) &&
      (this.checkNull(this.personalInformation.email)) &&
      (this.checkNull(this.personalInformation.dateOfBirth)) &&
      (this.checkNull(this.personalInformation.weight)) &&
      (this.checkNull(this.personalInformation.heigth)) &&
      (this.checkNull(this.personalInformation.placeOfBirth)) &&
      (this.checkNull(this.personalInformation.race)) &&
      (this.checkNull(this.personalInformation.nationality)) &&
      (this.checkNull(this.personalInformation.religion)) &&
      (this.checkNull(this.personalInformation.citizenID)) &&
      (this.checkNull(this.personalInformation.profNo)) &&
      (this.checkNull(this.personalInformation.militaryStatus)) &&
      (this.checkNull(this.personalInformation.maritalStatus))
  }

  private checkNull(field) {
    return field != "" && field != null
  }
}
