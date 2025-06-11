import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  titulo = 'notaFiscalFront';
  menuAberto = false;

  itensMenu = [
    { texto: 'Cliente', caminho: '/clientes' },
    { texto: 'Produtos', caminho: '/produtos' }
  ];

  opcoesBotaoMenu = {
    icon: 'menu',
    onClick: () => {
      this.menuAberto = !this.menuAberto;
    }
  };

  constructor(private roteador: Router) {}

  aoClicarItem(item: any) {
    this.roteador.navigate([item.caminho]);
    this.menuAberto = false;
  }

  aoAlterarOpcaoDoMenu(evento: any) {
    if (evento.name === 'opened') {
      this.menuAberto = evento.value;
    }
  }
}
