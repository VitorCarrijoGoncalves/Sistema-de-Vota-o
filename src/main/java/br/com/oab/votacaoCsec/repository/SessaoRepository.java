package br.com.oab.votacaoCsec.repository;

import br.com.oab.votacaoCsec.models.Votante;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oab.votacaoCsec.models.Sessao;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Sessao findByDataSessao(LocalDate dataSessao);

    Sessao findSessaoByTema(String tema);

    @Query("SELECT * FROM VOTANTE V" +
            "LEFT JOIN V ON V.id_opcao_voto")
    Votante findVotanteByIdOpcoesVotoAndIdOpcaoVoto(Sessao sessao);

}
