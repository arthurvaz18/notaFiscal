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
  mostrarDataGrid = false;
  mostrarDataGridPesquisa = false;


  clientes: Cliente[] = [];
  produtos: Produto[] = [];
  notasFiscaisEncontradas: NotaFiscal[] = [];

  novaNotaFiscal: NotaFiscal = {
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
  }

  mostrarCamposPesquisa(): void {
    this.mostrarFormularioPesquisa = !this.mostrarFormularioPesquisa;
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

  onDataHoraNotaFiscalCange(dataHora: Date | number | string) {
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

  calcularTotalItem = (data: any) => {
    return data.quantidade * data.precoUnitario;
  }

  removerItemNota(e: any) {
    const itemParaRemover = e.data;
    this.novaNotaFiscal.itens = this.novaNotaFiscal.itens.filter(item => item !== itemParaRemover);
    this.atualizarValorNota();
    this.mostrarDataGrid = this.novaNotaFiscal.itens.length > 0;
  }

  buscarNotaPorId():void{
    this.mainService.buscarNotaPorId(this.filtroIdNotaFiscal).subscribe({
      next: (notas)=> {
        console.log('Produtos recebidos:', notas);
        this.notasFiscaisEncontradas = [notas];
      },
      error: (erro) => console.error("Erro ao pesquisar Produto", erro)
    });
    this.mostrarDataGridPesquisa = true;
  }


}
