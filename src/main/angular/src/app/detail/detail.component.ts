import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  piIsValid = false
  registered = false
  isDraft = false
  registrationStatus = "not sent"
  constructor() { }

  ngOnInit() {
  }

}
