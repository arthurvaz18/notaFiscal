import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../services/cliente.service';
import { Cliente } from '../../models/cliente';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  mostrarFormulario = false;
  mostrarPesquisaCampos = false;
  mostrarAtualizarCampos = false;

  novoCliente: Cliente = { codigoCliente: '', nomeCliente: '' };
  clienteParaAtualizar: Cliente = { codigoCliente: '', nomeCliente: '' };

  filtroCodigoCliente = '';
  filtroNomeCliente = '';
  clientesEncontrados: Cliente[] = [];

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {}

  mostrarCampos(): void {
    this.mostrarFormulario = true;
    this.mostrarPesquisaCampos = false;
    this.mostrarAtualizarCampos = false;
    this.clientesEncontrados = [];
  }

  mostrarPesquisa(): void {
    this.mostrarPesquisaCampos = true;
    this.mostrarFormulario = false;
    this.mostrarAtualizarCampos = false;
    this.clientesEncontrados = [];
  }

  salvarCliente(): void {
    this.clienteService.cadastrarCliente(this.novoCliente).subscribe({
      next: () => {
        this.novoCliente = { codigoCliente: '', nomeCliente: '' };
        alert('Cliente cadastrado com sucesso!');
      },
      error: (erro) => console.error('Erro ao cadastrar cliente:', erro)
    });
  }

  pesquisarCliente(): void {
    this.clienteService.pesquisarCliente(this.filtroNomeCliente, this.filtroCodigoCliente).subscribe({
      next: (clientes) => this.clientesEncontrados = clientes,
      error: (erro) => console.error('Erro ao pesquisar clientes:', erro)
    });
  }

  editarCliente = (e: any): void => {
    this.clienteParaAtualizar = { ...e.row.data };
    this.mostrarAtualizarCampos = true;
    this.mostrarFormulario = false;
    this.mostrarPesquisaCampos = false;
  };

  atualizarCliente(): void {
    this.clienteService.atualizarCliente(this.clienteParaAtualizar).subscribe({
      next: () => {
        alert('Cliente atualizado com sucesso!');
        this.mostrarAtualizarCampos = false;
        this.pesquisarCliente();
      },
      error: (erro) => console.error('Erro ao atualizar cliente:', erro)
    });
  }

  cancelarAtualizacao(): void {
    this.mostrarAtualizarCampos = false;
    this.clienteParaAtualizar = { codigoCliente: '', nomeCliente: '' };
  }
}
