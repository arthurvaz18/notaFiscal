import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {ClienteComponent} from "./cliente.component";
import {DxButtonModule, DxFormModule, DxTextAreaModule, DxTextBoxModule, DxTileViewModule} from "devextreme-angular";


@NgModule({
  declarations: [
    ClienteComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    DxTextBoxModule,
    DxButtonModule,
    DxTextAreaModule,
    DxTileViewModule,
    DxFormModule,
  ],
  exports: [
    ClienteComponent
  ]
})
export class ClienteModule { }
