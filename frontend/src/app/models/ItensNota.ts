import {NotaFiscal} from "./notaFiscal";
import {Produto} from "./produto";

export interface ItensNota {
  id?: number;
  notaFiscal?: NotaFiscal;  // pode ser opcional para evitar ciclos de referência
  produto: Produto;
  quantidadeProduto: number;
  valorTotal: number;
  precoUnitario: number;
}
