import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-application13',
  templateUrl: './application13.component.html',
  styleUrls: ['./application13.component.css']
})
export class Application13Component implements OnInit {

  title = "โปรดระบุชื่อบุคคลที่สามารถรับรองท่านได้ 2 ชื่อ (ไม่ใช่ญาติ)"
  subtitle = "(Please provide two names for references (not relative))"

  constructor() { }

  ngOnInit() {
  }

}
