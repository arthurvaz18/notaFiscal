import { Injectable } from '@angular/core';
import {Produto} from "../models/produto";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private baseUrl = 'http://localhost:8080/produtos';

  constructor(private http: HttpClient) { }

  cadastrarProduto(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(this.baseUrl,produto);
  }
}
