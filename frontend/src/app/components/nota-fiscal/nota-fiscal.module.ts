import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {
  DxButtonModule,
  DxDataGridModule,
  DxFormModule, DxNumberBoxModule,
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
  ],
  exports: [
    NotaFiscalComponent
  ]
})
export class NotaFiscalModule { }
