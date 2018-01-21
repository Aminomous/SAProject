import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

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

import { AuthGuard } from "./auth.guard";

@NgModule({
  imports: [
    RouterModule.forRoot([
        {
          path: '',
          redirectTo: 'main',
          pathMatch: 'full'
        },
        {
          path: 'main',
          canActivate: [AuthGuard],
          component: MainComponent,
          children: [
            {
              path:'',
              component: DetailComponent
            },
            {
              path: 'info',
              component: InformationComponent,
              children: [
                {
                  path: '',
                  redirectTo: '1',
                  pathMatch: 'full'
                },
                {
                  path: '1',
                  component: Information1Component
                },
                {
                  path: '2',
                  component: Information2Component
                },
                {
                  path: '3',
                  component: Information3Component
                },
                {
                  path: '4',
                  component: Information4Component
                },
                {
                  path: '5',
                  component: Information5Component
                },
                {
                  path: '6',
                  component: Information6Component
                },
                {
                  path: '7',
                  component: Information7Component
                },
                {
                  path: '8',
                  component: Information8Component
                }
              ]
            },
            {
              path: 'registration',
              component: RegistrationFormComponent,
              children: [
                {
                  path: '',
                  redirectTo: '1',
                  pathMatch: 'full'
                },
                {
                  path: '1',
                  component: RegistrationForm1Component
                },
                {
                  path: '2',
                  component: RegistrationForm2Component
                },
                {
                  path: '3',
                  component: RegistrationForm3Component
                }
              ]
            }
          ]
        },
        {
          path: 'login',
          component: LoginFormComponent
        },
        {
          path: 'signup',
          component: RegisterComponent
        },
        {
          path: '**',
          component: NotFoundComponent
        }
      ])
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
