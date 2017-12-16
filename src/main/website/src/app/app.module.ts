import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { RoutingModule } from "./routing/routing.module";
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { HttpModule } from "@angular/http";

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { Application1Component } from './application1/application1.component';
import { Application2Component } from './application2/application2.component';
import { Application3Component } from './application3/application3.component';
import { Application4Component } from './application4/application4.component';
import { Application5Component } from './application5/application5.component';
import { Application6Component } from './application6/application6.component';
import { Application7Component } from './application7/application7.component';
import { Application8Component } from './application8/application8.component';
import { Application9Component } from './application9/application9.component';
import { Application10Component } from './application10/application10.component';
import { Application11Component } from './application11/application11.component';
import { Application12Component } from './application12/application12.component';
import { Application13Component } from './application13/application13.component';
import { Application14Component } from './application14/application14.component';

import { ApplicationService } from "./application.service";
import { ApplicationComponent } from './application/application.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    Application1Component,
    Application2Component,
    Application3Component,
    Application4Component,
    Application5Component,
    Application6Component,
    Application7Component,
    Application8Component,
    Application9Component,
    Application10Component,
    Application11Component,
    Application12Component,
    Application13Component,
    Application14Component,
    ApplicationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    Ng2SmartTableModule,
    RoutingModule,
    HttpModule
  ],
  providers: [ApplicationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
