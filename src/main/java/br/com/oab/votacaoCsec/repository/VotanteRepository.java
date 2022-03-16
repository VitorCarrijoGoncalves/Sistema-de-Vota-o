package br.com.oab.votacaoCsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oab.votacaoCsec.models.Votante;

import java.util.Optional;

public interface VotanteRepository extends JpaRepository<Votante, Long> {

    Optional<Votante> findByCpf(String cpf);

}
