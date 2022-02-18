package br.com.oab.votacaoCsec.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "opcao_voto")
public class OpcaoVoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private OpcoesVoto idOpcoesVoto;

    @OneToMany
    private List<Votante> votantes;

    @Column(name = "nome_opcao")
    private String nomeOpcao;

}
