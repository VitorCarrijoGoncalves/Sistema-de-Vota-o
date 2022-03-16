package br.com.oab.votacaoCsec.service.impl;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.OpcaoVotoRepository;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.OpcaoVotoService;
import br.com.oab.votacaoCsec.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OpcaoVotoServiceImpl implements OpcaoVotoService {
	
	@Autowired
	OpcaoVotoRepository opcaoVotoRepository;

	@Override
	public List<OpcaoVoto> findAll() {
		return opcaoVotoRepository.findAll();
	}

	@Override
	public OpcaoVoto findById(long id) {
		return opcaoVotoRepository.findById(id).get();
	}

	@Override
	public OpcaoVoto save(OpcaoVoto opcaoVoto) {
		return opcaoVotoRepository.saveAndFlush(opcaoVoto);
	}
}
