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

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: '', redirectTo: 'application/1', pathMatch: "full" },
      { path: 'application/1', component: Application1Component },
      { path: 'application/2', component: Application2Component },
      { path: 'application/3', component: Application3Component },
      { path: 'application/4', component: Application4Component },
      { path: 'application/5', component: Application5Component },
      { path: 'application/6', component: Application6Component },
      { path: 'application/7', component: Application7Component },
      { path: 'application/8', component: Application8Component },
      { path: 'application/9', component: Application9Component },
      { path: 'application/10', component: Application10Component },
      { path: 'application/11', component: Application11Component },
      { path: 'application/12', component: Application12Component },
      { path: 'application/13', component: Application13Component },
      { path: 'application/14', component: Application14Component }
    ])
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
