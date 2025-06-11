import {Component, OnInit} from '@angular/core';
import {ClienteService} from '../../services/cliente.service';
import {Cliente} from '../../models/cliente';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  //exibição de telas
  mostrarFormularioCadastro = false;
  mostrarFormularioPesquisa = false;
  mostrarAtualizarCampos = false;

  //Puxando Cadastro/Atualização do Cliente
  novoCliente: Cliente = {codigoCliente: '', nomeCliente: ''};
  clienteParaAtualizar: Cliente = {codigoCliente: '', nomeCliente: ''};


  //Filto de Pesquisa
  filtroCodigoCliente = '';
  filtroNomeCliente = '';
  clientesEncontrados: Cliente[] = [];

  //Excluir
  deletarSucesso: string = '';
  deletaMostraMensagem: boolean = false;
  clienteParaDeletar: Cliente | null = null;


  constructor(private clienteService: ClienteService) {
  }

  ngOnInit(): void {
  }

  //Navegação entre Formulários
  mostrarCamposCadastro(): void {
    this.mostrarFormularioCadastro = true;
    this.mostrarFormularioPesquisa = false;
    this.mostrarAtualizarCampos = false;
    this.clientesEncontrados = [];
  }

  //Navegação entre Formulários
  mostrarCamposPesquisa(): void {
    this.mostrarFormularioPesquisa = true;
    this.mostrarFormularioCadastro = false;
    this.mostrarAtualizarCampos = false;
    this.clientesEncontrados = [];
  }

  //Cadastrar Cliente
  cadastrarCliente(): void {
    this.clienteService.cadastrarCliente(this.novoCliente).subscribe({
      next: () => {
        this.novoCliente = {codigoCliente: '', nomeCliente: ''};
        alert('Cliente cadastrado com sucesso!');
      },
      error: (erro) => console.error('Erro ao cadastrar cliente:', erro)
    });
  }

  //Pesquisar Cliente
  pesquisarCliente(): void {
    this.clienteService.pesquisarCliente(this.filtroNomeCliente, this.filtroCodigoCliente).subscribe({
      next: (clientes) => this.clientesEncontrados = clientes,
      error: (erro) => console.error('Erro ao pesquisar clientes:', erro)
    });
  }

  //Editar/Atualizar Cliente
  editarCliente = (e: any): void => {
    this.clienteParaAtualizar = {...e.row.data};
    this.mostrarAtualizarCampos = true;
    this.mostrarFormularioCadastro = false;
    this.mostrarFormularioPesquisa = false;
  };

  //Atualiza Cliente
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
    this.clienteParaAtualizar = {codigoCliente: '', nomeCliente: ''};
  }

  deletarClienteGrid = (e: any): void => {
    this.clienteParaDeletar = e.row.data;
  }

  confirmarExcluir(): void {
    if (this.clienteParaDeletar?.id) {
      this.clienteService.deletarCliente(this.clienteParaDeletar.id).subscribe(() => {
        this.deletarSucesso = 'Cliente excluído com sucesso!';
        this.deletaMostraMensagem = true;
        this.pesquisarCliente();
      });
    }
  }

  cancelarExcluir(): void {
    this.clienteParaDeletar = null;
  }
}
