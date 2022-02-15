package br.com.oab.votacaoCsec.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "opcoes_voto")
public class OpcoesVoto {

    private long id;

    @OneToOne
    @JoinColumn(name = "id_sessao_id")
    private Sessao idSessao;

    private List<String> opcoesVoto;

    public Sessao getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Sessao idSessao) {
        this.idSessao = idSessao;
    }

    public List<String> getOpcoesVoto() {
        return opcoesVoto;
    }

    public void setOpcoesVoto(List<String> opcoesVoto) {
        this.opcoesVoto = opcoesVoto;
    }
}
