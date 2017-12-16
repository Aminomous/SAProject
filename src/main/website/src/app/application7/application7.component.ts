import { Component, OnInit } from '@angular/core';
import { Application } from 'app/models/application';
import { ApplicationService } from 'app/application.service';
import { Apprenticeship } from 'app/models/apprenticeship';

@Component({
  selector: 'app-application7',
  templateUrl: './application7.component.html',
  styleUrls: ['./application7.component.css']
})
export class Application7Component implements OnInit {
  numbers = []
  title = "ความสามารถพิเศษ (Special Ability)"
  
  constructor() { }
  
  ngOnInit() {
  }
  
}
