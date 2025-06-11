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
  mostrarFormularioPesquisa = false;
  mostrarAtualizarCampos = false;

  filtroCodigoProduto = '';
  filtroDescricaoProduto = '';
  produtosEncontrados: Produto[] = [];

  novoProduto: Produto = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''};
  produtoParaAtualizar: Produto = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''};


  constructor(private produtoService: ProdutoService) {
  }

  ngOnInit(): void {
  }

  mostrarCamposCadastro() {
    this.mostrarFormularioPesquisa = false;
    this.mostrarFormularioCadastro = !this.mostrarFormularioCadastro;
    this.mostrarAtualizarCampos = false;
    this.produtosEncontrados = [];
  }

  mostrarCamposPesquisa(): void{
    this.mostrarFormularioPesquisa = !this.mostrarFormularioPesquisa;
    this.mostrarFormularioCadastro = false;
    this.produtosEncontrados = [];
  }

  editarProduto = (e: any): void =>{
    this.produtoParaAtualizar = {...e.row.data};
    this.mostrarFormularioCadastro = false;
    this.mostrarFormularioPesquisa = false;
    this.mostrarAtualizarCampos = true;
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

  pesquisarProduto(): void{
    this.produtoService.pesquisarProduto(this.filtroCodigoProduto, this.filtroDescricaoProduto).subscribe({
      next: (produtos)=> {
        console.log('Produtos recebidos:', produtos);
        this.produtosEncontrados = produtos;
      },
      error: (erro) => console.error("Erro ao pesquisar Produto", erro)
    });
    this.mostrarAtualizarCampos = false;
  }

  atualizarProduto(): void{
    this.produtoService.atualizarProduto(this.produtoParaAtualizar).subscribe({
      next: () => {
        alert('Produto atualizado com sucesso!');
        this.mostrarAtualizarCampos = false;
        this.pesquisarProduto();
      },
      error: (erro) => console.error('Erro ao atualizar produto:', erro)
    });
  }

  cancelarAtualizacao(): void{
    this.mostrarAtualizarCampos = false;
    this.produtoParaAtualizar = {codigoProduto: '', valorProduto: 0, descricaoProduto: ''};
  }

}
