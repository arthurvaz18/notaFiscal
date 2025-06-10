import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {
  DxButtonModule,
  DxDrawerModule,
  DxFormModule,
  DxListModule,
  DxSelectBoxModule,
  DxToolbarModule, DxTreeListModule
} from "devextreme-angular";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    DxDrawerModule,
    DxListModule,
    DxToolbarModule,
    DxButtonModule,
    AppRoutingModule,
    DxSelectBoxModule,
    HttpClientModule,
    DxFormModule,
    DxTreeListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
