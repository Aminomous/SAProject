import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { Application1Component } from "../application1/application1.component";
import { Application2Component } from "../application2/application2.component";
import { Application3Component } from "../application3/application3.component";
import { Application4Component } from "../application4/application4.component";
import { Application5Component } from "../application5/application5.component";
import { Application6Component } from "../application6/application6.component";
import { Application7Component } from "../application7/application7.component";
import { Application8Component } from "../application8/application8.component";
import { Application9Component } from "../application9/application9.component";
import { Application10Component } from "../application10/application10.component";
import { Application11Component } from "../application11/application11.component";
import { Application12Component } from "../application12/application12.component";
import { Application13Component } from "../application13/application13.component";
import { Application14Component } from "../application14/application14.component";
import { ApplicationComponent } from 'app/application/application.component';
import { MainComponent } from 'app/main/main.component';

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: '', redirectTo: '/main', pathMatch: "full"},
      { path: 'main', component: MainComponent},
      { path: 'application', component: ApplicationComponent, children: [
        { path: '1', component: Application1Component, outlet: "application" },
        { path: '2', component: Application2Component, outlet: "application" },
        { path: '3', component: Application3Component, outlet: "application" },
        { path: '4', component: Application5Component, outlet: "application" },
        { path: '5', component: Application6Component, outlet: "application" },
        { path: '6', component: Application7Component, outlet: "application" },
        { path: '7', component: Application8Component, outlet: "application" },
        { path: '8', component: Application9Component, outlet: "application" },
        { path: '9', component: Application10Component, outlet: "application" },
        { path: '10', component: Application11Component, outlet: "application" },
        { path: '11', component: Application12Component, outlet: "application" },
        { path: '12', component: Application13Component, outlet: "application" },
        { path: '13', component: Application14Component, outlet: "application" }
      ]}
    ])
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
