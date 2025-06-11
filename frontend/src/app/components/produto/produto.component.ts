import {Component, OnInit} from '@angular/core';
import {ProdutoService} from "../../services/produto.service";
import {Produto} from "../../models/produto";

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  mostrarFormularioCadastro = false;
  mostrarPesquisaCampos = false;
  mostrarAtualizarCampos = false;

  novoProduto: Produto = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''};

  constructor(private produtoService: ProdutoService) {
  }

  ngOnInit(): void {
  }

  mostrarCampos() {
    this.mostrarPesquisaCampos = false;
    this.mostrarFormularioCadastro = !this.mostrarFormularioCadastro;
    this.mostrarAtualizarCampos = false;
  }

  cadastrarCliente(): void {
    this.produtoService.cadastrarProduto(this.novoProduto).subscribe({
      next: () => {
        this.novoProduto = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''}
        alert('Produto Cadastrado com sucesso!')
      },
      error: (erro) => console.error('Erro ao cadastrar Produdo:', erro)
    });
  }

}
