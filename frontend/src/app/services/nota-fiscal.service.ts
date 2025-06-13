import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NotaFiscal} from "../models/notaFiscal";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NotaFiscalService {
  private baseUrl = 'http://localhost:8080/notasFiscais';

  constructor( private http: HttpClient) { }

  criarNotaFiscal(notaFiscal: NotaFiscal): Observable<NotaFiscal>{
    return this.http.post<NotaFiscal>(this.baseUrl, notaFiscal);
  }
  buscarNotaPorId(id: number): Observable<NotaFiscal>{
    return this.http.get<NotaFiscal>(`${this.baseUrl}/${id}`);
  }
}
