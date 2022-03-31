package br.com.oab.votacaoCsec.service;

import java.util.List;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.models.Votante;
import org.springframework.stereotype.Service;

@Service
public interface VotanteService {
	
	List<Votante> findAll();
	
	Votante findById (long id);
	
	Votante save (Votante votante);

	boolean isVotanteNaoVotou(Long idVotante, Sessao sessao);

	boolean isVotanteNovo(Votante votante);

}
