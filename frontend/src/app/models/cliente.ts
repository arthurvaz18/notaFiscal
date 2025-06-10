export class Cliente{
  id?: number;
  codigoCliente: string;
  nomeCliente: string;

  constructor(init?: Partial<Cliente>) {
    Object.assign(this, init);
  }
}
