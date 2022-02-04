package br.com.oab.votacaoCsec.service;

import java.util.List;

import br.com.oab.votacaoCsec.models.Sessao;

public interface SessaoService {
	
	List<Sessao> findAll();
	
	Sessao findById (long id);
	
	Sessao save (Sessao sessao);
	
	

}
