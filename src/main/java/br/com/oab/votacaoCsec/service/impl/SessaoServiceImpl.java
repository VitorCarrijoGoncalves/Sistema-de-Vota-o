package br.com.oab.votacaoCsec.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.SessaoService;

@Service
public class SessaoServiceImpl implements SessaoService {
	
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

	@Override
	public boolean dataSessaoCoincideComOutraSessao(LocalDate dataSessao) {

		// Buscar sessão por data
		Sessao sessao = sessaoRepository.findByDataSessao(dataSessao);

		if (sessao != null) {
			if (dataSessao == sessao.getDataSessao()) {
				return true;
			} else {
				return false;
			}
		}

		return false;

	}

	public boolean validarTemaSessaoNaoERepetido(String tema) {

		// Buscar sessão por tema
		Sessao sessao = sessaoRepository.findSessaoByTema(tema);

		if (sessao != null) {
			if (tema.equalsIgnoreCase(sessao.getTema())) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
