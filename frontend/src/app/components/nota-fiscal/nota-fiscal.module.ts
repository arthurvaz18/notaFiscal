import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {
  DxButtonModule,
  DxDataGridModule, DxDateBoxModule,
  DxFormModule, DxNumberBoxModule, DxSelectBoxModule,
  DxTextAreaModule,
  DxTextBoxModule,
  DxTileViewModule
} from "devextreme-angular";
import {NotaFiscalComponent} from "./nota-fiscal.component";


@NgModule({
  declarations: [
    NotaFiscalComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    DxTextBoxModule,
    DxButtonModule,
    DxTextAreaModule,
    DxTileViewModule,
    DxFormModule,
    DxDataGridModule,
    DxNumberBoxModule,
    DxDateBoxModule,
    DxSelectBoxModule,
  ],
  exports: [
    NotaFiscalComponent
  ]
})
export class NotaFiscalModule { }
