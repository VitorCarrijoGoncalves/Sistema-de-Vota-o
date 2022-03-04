package br.com.oab.votacaoCsec.service;

import java.time.LocalDate;
import java.util.List;

import br.com.oab.votacaoCsec.models.Sessao;

public interface SessaoService {
	
	List<Sessao> findAll();
	
	Sessao findById (long id);
	
	Sessao save (Sessao sessao);
	
	Sessao update (Sessao sessao);

	boolean dataSessaoCoincideComOutraSessao(LocalDate dataSessao);

	boolean validarTemaSessaoNaoERepetido(String tema);

}
