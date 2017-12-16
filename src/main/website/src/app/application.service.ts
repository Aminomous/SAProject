import { Injectable } from '@angular/core';
import { Application } from 'app/models/application';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { PersonalInformation } from 'app/models/personalInformation';
import { Education } from 'app/models/education';

import { Http, RequestOptions, Headers } from "@angular/http";
import 'rxjs/add/operator/map'

@Injectable()
export class ApplicationService {
  host = "localhost"
  port = "80"
  php = "db_post.php"
  url = "http://"+this.host+":"+this.port+"/"+this.php

  headers = new Headers({ 'Content-Type': 'application/json' });
  options = new RequestOptions({ headers: this.headers });
  application: Application

  constructor(private http: Http) {
    
    this.createApplication()
    
  }

  testPost() {
    let app = new Application()
    app.date = new Date()
    app.salary = 2000
    app.position1 = "wow"
    app.workerType = "A"
    app.workInShift = true
    app.startingDate = new Date()
    app.personalInformation = new PersonalInformation()
    app.personalInformation.ID = "1129700129344"
    app.QH2 = "yes"
    app.QH3 = "yes"
    app.additionalInformation = "None"
    app.applicationStatus1 = false
    app.applicationStatus2 = false
    app.applicationStatus3 = false
    app.applicationStatus4 = false
    app.applicationStatus5 = false
    console.log(app);
    
    this.http.post("http://localhost/db_post.php", JSON.stringify(app), {headers: this.headers}).map((response) => {
      console.log(response.json);
      
    })
  }

  getApplication(): Observable<Application> {
    return of(this.application)
  }

  saveApplication() {
    
  }

  createApplication() {
    this.application = new Application()
    this.application.personalInformation = new PersonalInformation()
    this.application.hospitals = []
    this.application.educations = []
    this.application.educations.splice(0, 0, new Education())
  }

}
