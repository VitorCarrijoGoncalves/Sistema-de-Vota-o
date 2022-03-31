package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.OpcoesVoto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpcoesVotoService {

    List<OpcoesVoto> findAll();

    OpcoesVoto findById (long id);

    OpcoesVoto save (OpcoesVoto opcoesVoto);

}
