package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.Fiscal;

import java.util.List;

public interface FiscalService {

    List<Fiscal> findAll();

    Fiscal findById (long id);

    Fiscal save (Fiscal mesario);

}
