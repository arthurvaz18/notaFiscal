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

  novoCliente: Cliente = {
    codigoCliente: '',
    nomeCliente: ''
  };

  mostrarCampos(): void {
    this.mostrarFormulario = true;
  }
  constructor(private mainService: ClienteService) {
  }

  ngOnInit(): void {}

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

}
