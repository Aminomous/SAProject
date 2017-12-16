import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ApplicationService } from 'app/application.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private router: Router,
  private applicationService: ApplicationService) {
  }

  ngOnInit() {
  }

  apply() {
    this.applicationService.createApplication()
    this.router.navigate(['/application', {outlets: {application: '1'}}])
  }

  testPost() {
    this.applicationService.testPost()
  }

}
