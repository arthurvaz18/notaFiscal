import {Component, OnInit} from '@angular/core';
import {NotaFiscalService} from "../../services/nota-fiscal.service";
import {NotaFiscal} from "../../models/notaFiscal";
import {Cliente} from "../../models/cliente";
import {ClienteService} from "../../services/cliente.service";
import {ItensNota} from "../../models/ItensNota";
import {Produto} from "../../models/produto";
import {ProdutoService} from "../../services/produto.service";

@Component({
  selector: 'app-nota-fiscal',
  templateUrl: './nota-fiscal.component.html',
  styleUrls: ['./nota-fiscal.component.scss']
})
export class NotaFiscalComponent implements OnInit {

  mostrarFormularioCadastro = false;
  mostrarFormularioPesquisa = false;
  mostrarAtualizarCampos = false;
  mostrarDataGrid = false;
  mostrarDataGridPesquisa = false;

  notaParaDeletar: NotaFiscal | null = null;



  itensEdit: ItensNota = {
    produto: {} as Produto,
    quantidadeProduto: 1,
    valorTotal: 0,
    precoUnitario: 0
  }


  clientes: Cliente[] = [];
  produtos: Produto[] = [];
  notasFiscaisEncontradas: NotaFiscal[] = [];
  itensEncontrados: ItensNota[] = [];

  novaNotaFiscal: NotaFiscal = {
    dataHoraNotaFiscal: new Date(),
    cliente: new Cliente(),
    valorNotaFiscal: 0,
    itens: []
  };

  notaParaAtualizar: NotaFiscal = {
    dataHoraNotaFiscal: new Date(),
    cliente: new Cliente(),
    valorNotaFiscal: 0,
    itens: []
  };

  novoItem: ItensNota = {
    produto: {} as Produto,
    quantidadeProduto: 1,
    valorTotal: 0,
    precoUnitario: 0
  }

  filtroIdNotaFiscal: number = 0;

  constructor(private mainService: NotaFiscalService,
              private clienteService: ClienteService,
              private produtoService: ProdutoService) {
  }

  ngOnInit(): void {
    this.carregarClientes();
    this.carregarProdutos();
  }

  mostrarCamposCadastro() {
    this.mostrarFormularioPesquisa = false;
    this.mostrarFormularioCadastro = !this.mostrarFormularioCadastro;
    this.mostrarDataGrid = false;
    this.mostrarDataGridPesquisa = false;
  }

  mostrarCamposPesquisa(): void {
    this.mostrarFormularioPesquisa = !this.mostrarFormularioPesquisa;
    this.mostrarFormularioCadastro = false;
  }

  buscarClientePorCodigo(codigo: string) {
    const clienteEncontrado = this.clientes.find(client => client.codigoCliente === codigo);

    if (clienteEncontrado) {
      this.novaNotaFiscal.cliente.nomeCliente = clienteEncontrado.nomeCliente;
    } else {
      this.novaNotaFiscal.cliente.nomeCliente = '';
    }
  }

  carregarClientes() {
    this.clienteService.pesquisarCliente().subscribe({
      next: (dados: Cliente[]) => {
        this.clientes = dados;
      },
      error: (erro) => {
        console.error('Erro ao carregar clientes', erro);
      }
    })
  }

  cadastrarNotaFiscal(): void {
    this.novaNotaFiscal.dataHoraNotaFiscal = new Date(this.novaNotaFiscal.dataHoraNotaFiscal);
    console.log('Data que será enviada:', this.novaNotaFiscal.dataHoraNotaFiscal);
    this.mainService.criarNotaFiscal(this.novaNotaFiscal).subscribe({
      next: () => {
        this.novaNotaFiscal = {dataHoraNotaFiscal: new Date(), cliente: new Cliente(), valorNotaFiscal: 0, itens: []};
        alert('Nota Fiscal cadastrada com sucesso')
      },
      error(erro) {
        console.error("Não foi possível cadastrar essa nota fiscal", erro)
      }
    })
  }

  onDataHoraNotaFiscalChange(dataHora: Date | number | string) {
    if (dataHora instanceof Date) {
      this.novaNotaFiscal.dataHoraNotaFiscal = dataHora;
    } else {
      this.novaNotaFiscal.dataHoraNotaFiscal = new Date(dataHora);
    }
  }

  carregarProdutos(): void {
    this.produtoService.pesquisarProduto().subscribe({
      next: (dados: Produto[]) => {
        this.produtos = dados;
      },
      error: (erro) => {
        console.error('Erro ao carregar produtos', erro);
      }
    })
  }

  atualizarPrecoUnitario(codigo: string): void {
    for (let i = 0; i < this.produtos.length; i++) {
      let produtoUnitario = this.produtos[i];

      if (produtoUnitario.codigoProduto === codigo) {
        this.novoItem.produto = produtoUnitario;
        this.novoItem.precoUnitario = produtoUnitario.valorProduto;
        return;
      }
    }
    this.novoItem.produto = {} as Produto;
    this.novoItem.precoUnitario = 0;
  }

  atualizarValorNota() {
    this.novaNotaFiscal.valorNotaFiscal = this.calcularValorNota();
  }

  adicionarItemNota() {
    if (this.novoItem.produto && this.novoItem.quantidadeProduto > 0 && this.novoItem.precoUnitario > 0) {
      this.novoItem.valorTotal = this.novoItem.quantidadeProduto * this.novoItem.precoUnitario; // calcula total do item

      this.novaNotaFiscal.itens.push({
        ...this.novoItem,
      });

      this.novoItem = {
        produto: {} as Produto,
        quantidadeProduto: 1,
        valorTotal: 0,
        precoUnitario: 0
      };
      this.atualizarValorNota();
      this.mostrarDataGrid = true;
    } else {
      alert('Preencha todos os campos do item corretamente.');
    }
  }

  calcularValorNota(): number {
    return this.novaNotaFiscal.itens.reduce(
      (total, item) => total + (item.quantidadeProduto * item.precoUnitario),
      0.0
    );
  }

  removerItemNota(e: any) {
    const codigoParaRemover = e.data.produto.codigoProduto;

    this.novaNotaFiscal.itens = this.novaNotaFiscal.itens.filter(item => item.produto.codigoProduto !== codigoParaRemover);

    this.atualizarValorNota();
    this.mostrarDataGrid = this.novaNotaFiscal.itens.length > 0;
  }

  buscarNotaPorId(): void {
    this.mainService.buscarNotaPorId(this.filtroIdNotaFiscal).subscribe({
      next: (notas) => {
        console.log('Produtos recebidos:', notas);
        this.notasFiscaisEncontradas = [notas];
      },
      error: (erro) => console.error("Erro ao pesquisar Produto", erro)
    });
    this.mostrarDataGridPesquisa = true;
  }

  editarNotaFiscal = (e: any): void => {
    this.notaParaAtualizar = {...e.row.data};
    this.mostrarFormularioCadastro = true;
    this.mostrarFormularioPesquisa = false;
    this.itensEdit = { ...e.row.data };
    this.mostrarAtualizarCampos = true;
  }

  atualizaNotaFsical(): void {
    // Localiza o índice do item a ser atualizado no array de itens da nota
    const index = this.novaNotaFiscal.itens.findIndex(
      item => item.produto.codigoProduto === this.itensEdit.produto.codigoProduto
    );

    if (index !== -1) {
      this.itensEdit.valorTotal = this.itensEdit.quantidadeProduto * this.itensEdit.precoUnitario;
      this.novaNotaFiscal.itens[index] = { ...this.itensEdit };
      this.novaNotaFiscal.itens = [...this.novaNotaFiscal.itens];
      this.atualizarValorNota();
    }
    this.mostrarAtualizarCampos = false;
  }


  deletarNotaFiscal(event: any): void {
    const nota = event.data;
    const confirmacao = confirm(`Tem certeza que deseja excluir a nota fiscal de ID ${nota.id}?`);
    if (!confirmacao) {
      event.cancel = true;
      return;
    }
    this.mainService.deletarNotaFiscal(nota.id).subscribe({
      next: () => {
        alert('Nota fiscal excluída com sucesso.');
        this.notasFiscaisEncontradas = this.notasFiscaisEncontradas.filter(nf => nf.id !== nota.id);
      },
      error: (erro) => {
        console.error("Erro ao excluir nota fiscal", erro);
        alert("Erro ao tentar excluir a nota fiscal.");
      }
    });
  }

}
