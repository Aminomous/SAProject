import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { AuthService } from 'app/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  user:User = new User()
  error = null

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  loginUser(e) {
    this.authService.login(this.user)
    .subscribe((data)=>{
      // 
      
      if (data.text()=="true") {
        localStorage.setItem('user', this.user.email)
        this.router.navigate(['/'])
      } else {
        this.error = "E-mail or Password are incorrect, please try again."
      }
    }, (error)=>{
      
      this.error = "Can't connect to server."
    })
    
  }

  reset() {
    this.error = null
  }

}
