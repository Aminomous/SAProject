import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';

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
  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
