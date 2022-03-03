package br.com.oab.votacaoCsec.service.impl;

import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcaoVotoServiceImpl implements SessaoService {
	
	@Autowired
	SessaoRepository sessaoRepository;

	@Override
	public List<Sessao> findAll() {
		return sessaoRepository.findAll();
	}

	@Override
	public Sessao findById(long id) {
		return sessaoRepository.findById(id).get();
	}

	@Override
	public Sessao save(Sessao sessao) {
		return sessaoRepository.save(sessao);
	}

	@Override
	public Sessao update(Sessao sessao) {
		return sessaoRepository.saveAndFlush(sessao);
	}

}
