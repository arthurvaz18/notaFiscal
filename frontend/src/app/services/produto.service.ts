import {Injectable} from '@angular/core';
import {Produto} from "../models/produto";
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private baseUrl = 'http://localhost:8080/produtos';

  constructor(private http: HttpClient) { }

  cadastrarProduto(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(this.baseUrl,produto);
  }

  pesquisarProduto(codigoProduto?: string, descricaoProduto?: string): Observable<Produto[]> {
    let params = new HttpParams();

    if (codigoProduto) {
      params = params.set('codigoProduto', codigoProduto);
    }

    if (descricaoProduto) {
      params = params.set('descricaoProduto', descricaoProduto);
    }
    return this.http.get<Produto[]>(this.baseUrl, { params })
  }

  atualizarProduto(produto: Produto):Observable<Produto>{
    return this.http.put<Produto>(this.baseUrl + '/' + produto.id, produto);
  }

}
