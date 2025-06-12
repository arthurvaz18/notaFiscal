import {Cliente} from "./cliente";
import {ItensNota} from "./ItensNota";

export class NotaFiscal{
  id?: number;
  dataNotaFiscal: string; // ISO date string (ex: "2025-06-12")
  cliente: Cliente;
  valorNotaFiscal: number;
  itens: ItensNota[];

}
