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
import {ProdutoComponent} from "./produto.component";


@NgModule({
  declarations: [
    ProdutoComponent
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
    ProdutoComponent
  ]
})
export class ProdutoModule { }
