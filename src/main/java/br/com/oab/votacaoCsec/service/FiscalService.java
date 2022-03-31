package br.com.oab.votacaoCsec.service;

import br.com.oab.votacaoCsec.models.Fiscal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FiscalService {

    List<Fiscal> findAll();

    Fiscal findById (long id);

    Fiscal save (Fiscal mesario);

}
