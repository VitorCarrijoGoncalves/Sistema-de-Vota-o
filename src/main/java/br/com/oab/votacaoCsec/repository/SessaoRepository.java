package br.com.oab.votacaoCsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oab.votacaoCsec.models.Sessao;

import java.time.LocalDate;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Sessao findByDataSessao(LocalDate dataSessao);

}
