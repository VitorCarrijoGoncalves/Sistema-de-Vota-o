package br.com.oab.votacaoCsec.service.impl;

import java.util.List;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.oab.votacaoCsec.models.Votante;
import br.com.oab.votacaoCsec.repository.VotanteRepository;
import br.com.oab.votacaoCsec.service.VotanteService;
import org.springframework.stereotype.Service;

@Service
public class VotanteServiceImpl implements VotanteService {

	@Autowired
	VotanteRepository votanteRepository;

	@Autowired
	SessaoRepository sessaoRepository;

	@Override
	public List<Votante> findAll() {
		return votanteRepository.findAll();
	}

	@Override
	public Votante findById(long id) {
		return votanteRepository.findById(id).get();
	}

	@Override
	public Votante save(Votante votante) {
		return votanteRepository.save(votante);
	}

	@Override
	public boolean validarVotanteJaNaoVotou(Sessao sessao, Votante votante) {
		if (votanteRepository.findByOpcaoVotoAndVotante(sessao,votante) != null) {

			return true;

		}
			return false;

	}

	@Override
	public boolean isVotanteNovo(Votante votante) {
		if (votanteRepository.findByCpf(votante.getCpf()) != null) {
			return false;
		}

		return true;
	}

}
