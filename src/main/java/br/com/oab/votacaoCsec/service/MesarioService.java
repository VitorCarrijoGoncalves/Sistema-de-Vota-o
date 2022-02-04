package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.Mesario;
import br.com.oab.votacaoCsec.models.Sessao;

import java.util.List;

public interface MesarioService {

    List<Mesario> findAll();

    Mesario findById (long id);

    Mesario save (Mesario mesario);

}
