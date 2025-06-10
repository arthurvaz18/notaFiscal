export class Cliente{
  codigoCliente: string;
  nomeCliente: string;

  constructor(init?: Partial<Cliente>) {
    Object.assign(this, init);
  }
}
