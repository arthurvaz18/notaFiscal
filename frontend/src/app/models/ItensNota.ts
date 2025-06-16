import {NotaFiscal} from "./notaFiscal";
import {Produto} from "./produto";

export interface ItensNota {
  id?: number;
  notaFiscal?: NotaFiscal;
  produto: Produto;
  quantidadeProduto: number;
  valorTotal: number;
  precoUnitario: number;
}
