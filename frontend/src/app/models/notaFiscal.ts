import {Cliente} from "./cliente";
import {ItensNota} from "./ItensNota";

export class NotaFiscal{
  id?: number;
  dataHoraNotaFiscal: Date;
  cliente: Cliente;
  valorNotaFiscal: number;
  itens: ItensNota[];
}
