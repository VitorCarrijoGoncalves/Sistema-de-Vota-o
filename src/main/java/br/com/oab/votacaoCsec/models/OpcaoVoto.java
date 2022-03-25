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
    private List<Votante> listVotante;

    @ManyToMany
    private List<Sessao> listSessao;

    @Column(name = "nome_opcao")
    private String nomeOpcao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OpcoesVoto getIdOpcoesVoto() {
        return idOpcoesVoto;
    }

    public void setIdOpcoesVoto(OpcoesVoto idOpcoesVoto) {
        this.idOpcoesVoto = idOpcoesVoto;
    }

    public List<Votante> getListVotante() {
        return listVotante;
    }

    public void setListVotante(List<Votante> listVotante) {
        this.listVotante = listVotante;
    }

    public String getNomeOpcao() {
        return nomeOpcao;
    }

    public void setNomeOpcao(String nomeOpcao) {
        this.nomeOpcao = nomeOpcao;
    }
}
