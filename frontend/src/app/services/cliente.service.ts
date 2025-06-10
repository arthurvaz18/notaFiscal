import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Cliente} from "../models/cliente";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private baseUrl = 'http://localhost:8080/clientes';

  constructor(private http: HttpClient) { }

  cadastrarCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.baseUrl, cliente);
  }

  pesquisarCliente(nomeCliente?: string, codigoCliente?: string): Observable<Cliente[]>{
    let params = new HttpParams();

    if(nomeCliente){
      params = params.set('nomeCliente', nomeCliente);
    }

    if (codigoCliente) {
      params = params.set('codigoCliente', codigoCliente);
    }
    return this.http.get<Cliente[]>(this.baseUrl, { params })
  }

  atualizarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(this.baseUrl + '/' + cliente.id, cliente);
  }

  deletarCliente(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
