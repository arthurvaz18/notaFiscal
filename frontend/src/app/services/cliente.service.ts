import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
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
}
