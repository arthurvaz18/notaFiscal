import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClienteComponent} from "./components/cliente/cliente.component";
import {ProdutoComponent} from "./components/produto/produto.component";

const routes: Routes = [
  { path: 'clientes', component: ClienteComponent },
  { path: 'produtos', component: ProdutoComponent },

  { path: '', redirectTo: 'cliente', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
