package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpcaoVotoListVotanteService {

    List<OpcaoVoto> findAll();

    OpcaoVoto findById (long id);

    OpcaoVoto save (OpcaoVoto opcaoVoto);

}
