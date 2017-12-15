import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  date: Date
  page = 1
  constructor() { }

  ngOnInit() {
  }

  testDate() {
    console.log(this.date)
  }

  back() {
    this.page-=1
  }

  next() {
    this.page+=1
  }

  cancel() {
  }

  submit() {
  }

  isInvalidForm() : boolean {
    return true
  }

}
