import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes} from "@angular/router";
import {ProdutoComponent} from "./produto.component";

const routes: Routes =[

  { path: 'produtos', component: ProdutoComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ProdutoRoutingModule { }
