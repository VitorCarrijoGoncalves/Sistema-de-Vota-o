package br.com.oab.votacaoCsec.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.oab.votacaoCsec.enums.StatusSessaoEnum;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "Sessao")
public class Sessao {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String pautaInicial;
	
	@NotNull
	private String tema;

	private Long numeroProcesso;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataSessao;

	@NotNull
	private String pautaFinal;

	private String enderecoSessao;

	private String linkSessao;
	
	//@NotNull
	//private List<Votante> listaVotantes;
	
//	@NotNull
//	@OneToMany
//	private List<String> opcoesVoto;

	@NotNull
	@OneToOne
	private OpcoesVoto idOpcaoVoto;
	
	@NotNull
	private StatusSessaoEnum statusSessao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPautaInicial() {
		return pautaInicial;
	}

	public void setPautaInicial(String pautaInicial) {
		this.pautaInicial = pautaInicial;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(Long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public LocalDate getDataSessao() {
		return dataSessao;
	}

	public void setDataSessao(LocalDate dataSessao) {
		this.dataSessao = dataSessao;
	}

	public String getPautaFinal() {
		return pautaFinal;
	}

	public void setPautaFinal(String pautaFinal) {
		this.pautaFinal = pautaFinal;
	}

	public String getEnderecoSessao() {
		return enderecoSessao;
	}

	public void setEnderecoSessao(String enderecoSessao) {
		this.enderecoSessao = enderecoSessao;
	}

	public String getLinkSessao() {
		return linkSessao;
	}

	public void setLinkSessao(String linkSessao) {
		this.linkSessao = linkSessao;
	}

	public StatusSessaoEnum getStatusSessao() {
		return statusSessao;
	}

	public void setStatusSessao(StatusSessaoEnum statusSessao) {
		this.statusSessao = statusSessao;
	}

	public OpcoesVoto getIdOpcaoVoto() {
		return idOpcaoVoto;
	}

	public void setIdOpcaoVoto(OpcoesVoto idOpcaoVoto) {
		this.idOpcaoVoto = idOpcaoVoto;
	}
}
