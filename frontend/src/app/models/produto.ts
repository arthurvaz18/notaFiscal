export class Produto{
  id?: number;
  codigoProduto: string;
  valorProduto: number;
  descricaoProduto: string;

  constructor(init?: Partial<Produto>) {
    Object.assign(this, init);
  }
}
