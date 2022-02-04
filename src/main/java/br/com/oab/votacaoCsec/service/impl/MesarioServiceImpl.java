package br.com.oab.votacaoCsec.service.impl;

import br.com.oab.votacaoCsec.models.Mesario;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.MesarioRepository;
import br.com.oab.votacaoCsec.repository.SessaoRepository;
import br.com.oab.votacaoCsec.service.MesarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesarioServiceImpl implements MesarioService {

	@Autowired
	MesarioRepository mesarioRepository;

	@Override
	public List<Mesario> findAll() {
		return mesarioRepository.findAll();
	}

	@Override
	public Mesario findById(long id) {
		return mesarioRepository.findById(id).get();
	}

	@Override
	public Mesario save(Mesario mesario) {
		return mesarioRepository.save(mesario);
	}
}
