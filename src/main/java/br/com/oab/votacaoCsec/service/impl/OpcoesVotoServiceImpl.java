package br.com.oab.votacaoCsec.service.impl;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.OpcoesVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.OpcaoVotoRepository;
import br.com.oab.votacaoCsec.repository.OpcoesVotoRepository;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.OpcoesVotoService;
import br.com.oab.votacaoCsec.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcoesVotoServiceImpl implements OpcoesVotoService {
	
	@Autowired
	OpcoesVotoRepository opcoesVotoRepository;

	@Autowired
	OpcaoVotoRepository opcaoVotoRepository;

	@Override
	public List<OpcoesVoto> findAll() {
		return opcoesVotoRepository.findAll();
	}

	@Override
	public OpcoesVoto findById(long id) {
		return opcoesVotoRepository.findById(id).get();
	}

	@Override
	public OpcoesVoto save(OpcoesVoto opcoesVoto) {

		// Elementos da lista de opcaoVoto já precisam estar registrados no banco, na tabela OpcaoVoto
		if (!isListaOpcaoVotoContemElementosTabelaOpcaoVoto(opcoesVoto)) {
			return null;
		}

		return opcoesVotoRepository.saveAndFlush(opcoesVoto);

	}

	public boolean isListaOpcaoVotoContemElementosTabelaOpcaoVoto(OpcoesVoto opcoesVoto) {

		for (int i = 0; i < opcoesVoto.getListOpcaoVoto().size(); i++) {
			Optional<OpcaoVoto> opcaoVoto = opcaoVotoRepository.findById(opcoesVoto.getListOpcaoVoto().get(i).getId());
			if (!opcaoVoto.isPresent()) {
				return false;
			}
		}

		return true;

	}

}
