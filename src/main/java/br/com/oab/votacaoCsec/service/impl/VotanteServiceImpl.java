package br.com.oab.votacaoCsec.service.impl;

import java.util.List;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.OpcaoVotoService;
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

	@Autowired
	OpcaoVotoService opcaoVotoService;

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

	/* Método para validar se o votante já votou uma vez na sessão ou n, e se for o caso,
	* não deixar ele votar novamente.*/
	@Override
	public boolean isVotanteNaoVotou(Long idVotante, Sessao sessao) {

		List<Long> idsOpcaoVoto = opcaoVotoService.findVotanteById(idVotante);

		if (idsOpcaoVoto.size() > 1) {
				return false;
		}

		return true;

	}

	/* Método para validar se o votante está realmente fazendo um novo cadastro, ou se ele está
	* cadastrando novamente.*/
	@Override
	public boolean isVotanteNovo(Votante votante) {
		if (votanteRepository.findByCpf(votante.getCpf()) != null) {
			return false;
		}

		return true;
	}

}
