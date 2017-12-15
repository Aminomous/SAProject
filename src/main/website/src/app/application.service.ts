import { Injectable } from '@angular/core';
import { Application } from 'app/models/application';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { PersonalInformation } from 'app/models/personalInformation';

@Injectable()
export class ApplicationService {

  application: Application

  constructor() { 
    this.createApplication()
  }

  getApplication(): Observable<Application> {
    return of(this.application)
  }

  updateApplication(application: Application) {
    this.application = application
  }

  createApplication() {
    this.application = new Application()
    this.application.personalInformation = new PersonalInformation()
    this.application.hospitals = []
  }

}
