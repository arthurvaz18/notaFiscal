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

  filtroCodigoProduto = '';
  filtroDescricaoProduto = '';
  produtosEncontrados: Produto[] = [];

  novoProduto: Produto = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''};

  constructor(private produtoService: ProdutoService) {
  }

  ngOnInit(): void {
  }

  mostrarCampos() {
    this.mostrarPesquisaCampos = false;
    this.mostrarFormularioCadastro = !this.mostrarFormularioCadastro;
    this.mostrarAtualizarCampos = false;
    this.produtosEncontrados = [];
  }

  mostrarPesquisa(): void{
    this.mostrarPesquisaCampos = !this.mostrarPesquisaCampos;
    this.mostrarFormularioCadastro = false;
    this.produtosEncontrados = [];
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

  pesquisaProduto(): void{
    this.produtoService.pesquisarProduto(this.filtroCodigoProduto, this.filtroDescricaoProduto).subscribe({
      next: (produtos)=> {
        console.log('Produtos recebidos:', produtos);
        this.produtosEncontrados = produtos;
      },
      error: (erro) => console.error("Erro ao pesquisar Produto", erro)
    });
  }

}
