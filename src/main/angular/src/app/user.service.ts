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
    console.log(email)
    let res = await this.http.post("http://localhost/testauthapp/get_info.php", JSON.stringify(email), {headers: this.headers}).toPromise()
    this.personalInformation = JSON.parse(res.text())
    return this.personalInformation
  }

  async loadApplication() {
    let cid = this.personalInformation.citizenID
    console.log(cid)
    let res = await this.http.post("http://localhost/testauthapp/get_app.php", JSON.stringify(cid), {headers: this.headers}).toPromise()
    this.application = JSON.parse(res.text())
    return this.application
  }

  getPersonalInformation() {
    return of(this.personalInformation)
  }

  getApplication() {
    return of(this.application)
  }

  checkPersonalInformation() {

  }
}
