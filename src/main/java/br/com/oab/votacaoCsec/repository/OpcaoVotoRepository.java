package br.com.oab.votacaoCsec.repository;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoVotoRepository extends JpaRepository<OpcaoVoto, Long> {

}
