import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {NotaFiscalComponent} from "./nota-fiscal.component";

const routes: Routes =[

  { path: 'notasFiscais', component: NotaFiscalComponent}
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NotaFiscalRoutingModule { }
