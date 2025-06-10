import {Component, OnInit} from '@angular/core';
import {ClienteService} from "../../services/cliente.service";
import {Cliente} from "../../models/cliente";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  mostrarFormulario: boolean = false;
  mostrarPesquisaCampos: boolean = false;


  novoCliente: Cliente = {
    codigoCliente: '',
    nomeCliente: ''
  };

  filtroCodigoCliente: string = '';
  filtroNomeCliente: string = '';
  clientesEncontrados: Cliente[] = [];

  constructor(private mainService: ClienteService) {
  }

  ngOnInit(): void {}

  mostrarPesquisa(): void{
    this.mostrarPesquisaCampos = !this.mostrarPesquisaCampos
    this.mostrarFormulario = false;

  }
  mostrarCampos(): void {
    this.mostrarFormulario = !this.mostrarFormulario;
    this.mostrarPesquisaCampos = false;

  }

  salvarCliente(): void{
    this.mainService.cadastrarCliente(this.novoCliente).subscribe({
      next: (resposta) =>{
        console.log('Cliente cadastrado com sucesso:', resposta);
        this.novoCliente = { codigoCliente: '', nomeCliente: '' }
      },
      error: (erro) =>{
        console.error('Erro ao cadastrar cliente:', erro);
      }
    })
  }
  pesquisarCliente(): void {
    this.mainService.pesquisarCliente(this.filtroNomeCliente, this.filtroCodigoCliente).subscribe({
      next: (clientes) => {
        this.clientesEncontrados = clientes;
        console.log('Clientes encontrados:', clientes);
      },
      error: (erro) => {
        console.error('Erro ao pesquisar clientes:', erro);
      }
    });
  }

}
