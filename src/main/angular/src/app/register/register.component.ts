import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormGroup, AbstractControl, FormControl } from "@angular/forms";
import { User } from '../models/user';
import { PasswordValidator } from './password.validator';
import { UserService } from 'app/user.service';
import { AuthService } from 'app/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  formSubmitted = false
  
  user:User = {
    email: "",
    password: ""
  }
  pi =  {
    firstName: "",
    lastName: "",
    c_ID: "",
    email: ""
  }
  mainError = "";
  emailError = "E-mail address format is incorrect."
  idError = "Citizen ID is in wrong format."
  passwordMatchError = "Password does not match!"

  signupForm:FormGroup
  
  constructor(
    private authService:AuthService, 
    private userService:UserService,
    private formBuilder: FormBuilder, 
    private router:Router
  ) {
    
  }

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      citizenID: ['', [Validators.required, Validators.maxLength(13), Validators.minLength(13), Validators.pattern('[0-9]+')]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      password: ['', [Validators.required]],
      passwordConfirm: ['', [Validators.required, PasswordValidator]],
    })
  }

  cancel() {
    this.router.navigate(['/'])
  }

  onFormSubmit() {
    if (this.signupForm.valid) {
      this.mainError = ""
      this.formSubmitted = true
      this.user.email = this.signupForm.value.email
      this.user.password = this.signupForm.value.password
      this.pi.firstName = this.signupForm.value.firstName
      this.pi.lastName = this.signupForm.value.lastName
      this.pi.c_ID = this.signupForm.value.citizenID
      this.pi.email = this.signupForm.value.email
      console.log(this.pi, this.user)
      this.userService.createUser({user: this.user, pi:this.pi})
      .subscribe((data) => {
        console.log(data)
        let res = data.text()
        if (res == "0") {
          this.authService.login(this.user)
          .subscribe((data) => {
            console.log(data)
            if (data.text()=="true") {
              localStorage.setItem('user', this.user.email)
              this.router.navigate(['/'])
            } else {
              
            }
          }, (error) => {
            console.log("An error occurred while logging in!",error)
          })
        } else if (res == "1") {
          this.mainError = "หมายเลขประจำตัวประชาชนนี้ถูกใช้ไปแล้ว"
          this.signupForm.get('citizenID').setValue('')
          this.signupForm.get('citizenID').markAsUntouched()
        } else if (res == "2") {
          this.mainError = "อีเมลนี้ถูกใช้ไปแล้ว"
          this.signupForm.get('email').setValue('')
          this.signupForm.get('email').markAsUntouched()
        } else if (res == "3") {
          this.mainError = "ระบบขัดข้อง กรุณาลองใหม่อีกครั้งในภายหลัง"
        }
        
      }, (error) => {
        console.log("An error occurred while creating new user!",error)
      })
    }
  }

}
