package br.com.oab.votacaoCsec.models;

import javax.persistence.*;

import com.danielfariati.annotation.CPF;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.List;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "votante")
public class Votante implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "login")
	private String login;

	@NotNull
	@Column(name = "senha")
	private String senha;
	
	@NotNull
	@CPF(required = true, message = "CPF inválido")
	@Column(name = "cpf")
	private String cpf;

	@NotNull
	@ManyToMany
	private List<OpcaoVoto> listOpcaoVoto;

	@ManyToMany
	private List<Sessao> listSessao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<OpcaoVoto> getListOpcaoVoto() {
		return listOpcaoVoto;
	}

	public void setListOpcaoVoto(List<OpcaoVoto> listOpcaoVoto) {
		this.listOpcaoVoto = listOpcaoVoto;
	}

	public List<Sessao> getListSessao() {
		return listSessao;
	}

	public void setListSessao(List<Sessao> listSessao) {
		this.listSessao = listSessao;
	}
}
