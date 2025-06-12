import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ProdutoComponent } from './components/produto/produto.component';
import { NotaFiscalComponent } from './components/nota-fiscal/nota-fiscal.component';

const routes: Routes = [
  { path: 'clientes', component: ClienteComponent, data: [{ title: 'Lista de Clientes' }] },
  { path: 'produtos', component: ProdutoComponent, data: [{ title: 'Lista de Produtos' }] },
  { path: 'notasFiscais', component: NotaFiscalComponent, data: [{ title: 'Notas Fiscais' }] },

  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  { path: '**', redirectTo: 'clientes' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
