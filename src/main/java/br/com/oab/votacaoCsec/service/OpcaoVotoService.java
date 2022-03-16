package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.OpcaoVoto;

import java.util.List;

public interface OpcaoVotoService {

    List<OpcaoVoto> findAll();

    OpcaoVoto findById (long id);

    OpcaoVoto save (OpcaoVoto opcaoVoto);

}
