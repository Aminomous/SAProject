import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from "@angular/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RoutingModule } from './app-routing';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { MainComponent } from './main/main.component';
import { RegisterComponent } from './register/register.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { InformationComponent } from './information/information.component';
import { DetailComponent } from './detail/detail.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { Information1Component } from './information1/information1.component';
import { Information2Component } from './information2/information2.component';
import { Information3Component } from './information3/information3.component';
import { Information4Component } from './information4/information4.component';
import { Information5Component } from './information5/information5.component';
import { Information6Component } from './information6/information6.component';
import { Information7Component } from './information7/information7.component';
import { Information8Component } from './information8/information8.component';
import { RegistrationForm1Component } from './registration-form1/registration-form1.component';
import { RegistrationForm2Component } from './registration-form2/registration-form2.component';
import { RegistrationForm3Component } from './registration-form3/registration-form3.component';

import { UserService } from "./user.service";
import { AuthService } from 'app/auth.service';
import { AuthGuard } from "./auth.guard";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    RegisterComponent,
    LoginFormComponent,
    NotFoundComponent,
    InformationComponent,
    DetailComponent,
    RegistrationFormComponent,
    Information1Component,
    Information2Component,
    Information3Component,
    Information4Component,
    Information5Component,
    Information6Component,
    Information7Component,
    Information8Component,
    RegistrationForm1Component,
    RegistrationForm2Component,
    RegistrationForm3Component
  ],
  imports: [
    RoutingModule,
    HttpModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    UserService,
    AuthService,
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
