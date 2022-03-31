package br.com.oab.votacaoCsec.repository;

import br.com.oab.votacaoCsec.models.OpcoesVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcoesVotoRepository extends JpaRepository<OpcoesVoto, Long> {

}
