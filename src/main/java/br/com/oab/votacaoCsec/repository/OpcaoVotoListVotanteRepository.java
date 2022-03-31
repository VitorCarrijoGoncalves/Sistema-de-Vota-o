package br.com.oab.votacaoCsec.repository;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcaoVotoListVotanteRepository extends JpaRepository<OpcaoVoto, Long> {

    @Query("SELECT opcao_voto_id FROM opcao_voto_list_votante WHERE list_votante_id = ?")
    List<Long> findIdOpcaoVotoByIdVotante(Long idVotante);

}
