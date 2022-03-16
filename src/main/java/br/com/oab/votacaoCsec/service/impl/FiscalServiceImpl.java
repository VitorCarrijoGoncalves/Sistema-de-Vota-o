package br.com.oab.votacaoCsec.service.impl;

import br.com.oab.votacaoCsec.models.Fiscal;
import br.com.oab.votacaoCsec.repository.FiscalRepository;
import br.com.oab.votacaoCsec.service.FiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiscalServiceImpl implements FiscalService {

	@Autowired
	FiscalRepository mesarioRepository;

	@Override
	public List<Fiscal> findAll() {
		return mesarioRepository.findAll();
	}

	@Override
	public Fiscal findById(long id) {
		return mesarioRepository.findById(id).get();
	}

	@Override
	public Fiscal save(Fiscal mesario) {
		return mesarioRepository.save(mesario);
	}
}
