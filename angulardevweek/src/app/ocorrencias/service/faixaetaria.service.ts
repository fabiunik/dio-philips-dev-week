import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Faixaetaria } from '../model/faixaetaria';

@Injectable({
  providedIn: 'root'
})
export class FaixaetariaService {

  constructor(private http:HttpClient) { }

  listFaixaEtaria(): Observable<Faixaetaria[]>{
    const url2 = '/api/faixaetaria';
    return this.http.get<Faixaetaria[]>(url2);
  }

  //configuração antes das alterações para integração front-end/back-end
 /* constructor(){}

  listFaixaEtaria(): Faixaetaria[]{
    return [
      { id: 1, faixa_i: 0, faixa_n: 14, descricao: 'Até 14 anos'},
      { id: 2, faixa_i: 15, faixa_n: 19, descricao: 'Entre 15 e 19 anos'}
    ];
  }*/
}
