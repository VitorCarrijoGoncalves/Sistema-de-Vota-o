package br.com.oab.votacaoCsec.models;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.oab.votacaoCsec.enums.StatusSessaoEnum;

@Entity
@Table(name = "sessao")
public class Sessao {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "pauta_inicial")
	private String pautaInicial;
	
	@NotNull
	@Column(name = "tema")
	private String tema;

	@Column(name = "numero_processo")
	private Long numeroProcesso;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "data_sessao")
	private LocalDate dataSessao;

	@NotNull
	@Column(name = "pauta_final")
	private String pautaFinal;

	@Column(name = "endereco_sessao")
	private String enderecoSessao;

	@Column(name = "link_sessao")
	private String linkSessao;

	@NotNull
	@ManyToOne
	private GrupoOpcoesVoto idGrupoOpcoesVoto;
	
	@NotNull
	@Column(name = "status_sessao")
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



}
