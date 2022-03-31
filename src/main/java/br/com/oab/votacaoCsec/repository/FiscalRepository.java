package br.com.oab.votacaoCsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oab.votacaoCsec.models.Fiscal;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalRepository extends JpaRepository<Fiscal, Long> {

}
