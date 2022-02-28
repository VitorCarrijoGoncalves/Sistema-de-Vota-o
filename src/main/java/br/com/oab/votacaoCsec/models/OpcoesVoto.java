package br.com.oab.votacaoCsec.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "opcoes_voto")
public class OpcoesVoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany
    private List<Sessao> listSessao;

    @OneToMany
    private List<OpcaoVoto> listOpcaoVoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Sessao> getListSessao() {
        return listSessao;
    }

    public void setListSessao(List<Sessao> listSessao) {
        this.listSessao = listSessao;
    }

    public List<OpcaoVoto> getListOpcaoVoto() {
        return listOpcaoVoto;
    }

    public void setListOpcaoVoto(List<OpcaoVoto> listOpcaoVoto) {
        this.listOpcaoVoto = listOpcaoVoto;
    }
}
