package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.OpcoesVoto;

import java.util.List;

public interface OpcoesVotoService {

    List<OpcoesVoto> findAll();

    OpcoesVoto findById (long id);

    OpcoesVoto save (OpcoesVoto opcoesVoto);

}
