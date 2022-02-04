package br.com.oab.votacaoCsec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.oab.votacaoCsec.models.Votante;
import br.com.oab.votacaoCsec.repository.EleitorRepository;
import br.com.oab.votacaoCsec.service.EleitorService;
import org.springframework.stereotype.Service;

@Service
public class EleitorServiceImpl implements EleitorService {

	@Autowired
	EleitorRepository eleitorRepository;

	@Override
	public List<Votante> findAll() {
		return eleitorRepository.findAll();
	}

	@Override
	public Votante findById(long id) {
		return eleitorRepository.findById(id).get();
	}

	@Override
	public Votante save(Votante eleitor) {
		return eleitorRepository.save(eleitor);
	}

}
