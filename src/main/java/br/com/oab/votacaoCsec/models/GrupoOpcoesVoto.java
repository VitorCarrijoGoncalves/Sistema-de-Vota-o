package br.com.oab.votacaoCsec.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo_opcoes_voto")
public class GrupoOpcoesVoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany
    private List<Sessao> sessoes;

    @OneToMany
    private List<OpcaoVoto> opcoesVoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public List<OpcaoVoto> getOpcoesVoto() {
        return opcoesVoto;
    }

    public void setOpcoesVoto(List<OpcaoVoto> opcoesVoto) {
        this.opcoesVoto = opcoesVoto;
    }
}
