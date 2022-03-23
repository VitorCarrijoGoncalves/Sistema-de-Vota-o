package br.com.oab.votacaoCsec.service;

import java.util.List;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.models.Votante;

public interface VotanteService {
	
	List<Votante> findAll();
	
	Votante findById (long id);
	
	Votante save (Votante votante);

	boolean validarVotanteJaNaoVotou(Sessao sessao);

	boolean isVotanteNovo(Votante votante);

}
