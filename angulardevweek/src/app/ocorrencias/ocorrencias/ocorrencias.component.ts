import { Component, OnInit } from '@angular/core';
import { Faixaetaria } from '../model/faixaetaria';
import { Incidencia } from '../model/incidencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { IncidenciaService } from '../service/incidencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  incidencia: Incidencia[] = [];
  regioes: Regiao[] = [];
  faixaetaria: Faixaetaria[] = [];

  constructor(
    private regiaoService:RegiaoService,
    private incidenciaService: IncidenciaService,
    private faixaEtariaService: FaixaetariaService
    ) { }

  ngOnInit(): void {
    this.regiaoService.listRegioes().subscribe(regioes => {this.regioes = regioes});
    this.incidenciaService.listIncidencias().subscribe(incidencia => {this.incidencia = incidencia});
    this.faixaEtariaService.listFaixaEtaria().subscribe(faixaetaria => {this.faixaetaria = faixaetaria});
  }

}
