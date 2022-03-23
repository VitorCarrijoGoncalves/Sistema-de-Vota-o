package br.com.oab.votacaoCsec.repository;

import br.com.oab.votacaoCsec.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oab.votacaoCsec.models.Votante;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VotanteRepository extends JpaRepository<Votante, Long> {

    Optional<Votante> findByCpf(String cpf);

    @Query("SELECT * FROM opcao_voto ov LEFT JOIN opcoes_voto_list_votante ovlv " +
            "ON ov.id = ovlv.opcao_voto_id WHERE ov.id_opcoes_voto_id = {idOpcoesVoto} " +
            "AND ovlv.list_votante_id = {votante.getId()}")
    Optional<Votante> findByOpcaoVotoAndVotante(Sessao sessao, Votante votante);

    // SELECT * FROM opcao_voto ov
    // LEFT JOIN opcoes_voto_list_votante ovlv ON ov.id = ovlv.opcao_voto_id
    // WHERE ov.id_opcoes_voto_id = {idOpcoesVoto} AND ovlv.list_votante_id = {votante.getId()}


}
