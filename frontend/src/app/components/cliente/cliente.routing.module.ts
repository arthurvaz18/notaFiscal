import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes} from "@angular/router";
import {ClienteComponent} from "./cliente.component";

const routes: Routes =[

  { path: 'cliente', component: ClienteComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ClienteRoutingModule { }
