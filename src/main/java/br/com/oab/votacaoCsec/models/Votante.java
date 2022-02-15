package br.com.oab.votacaoCsec.models;

import javax.persistence.*;

import com.danielfariati.annotation.CPF;
import com.sun.istack.NotNull;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "Votante")
public class Votante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String login;

	@NotNull
	private String senha;
	
	@NotNull
	@CPF(required = true, message = "CPF inválido")
	private String cpf;

	@NotNull
	private String voto;

//	@ManyToOne
//	@JoinColumn(name = "id_sessao")
//	@NotNull
//	private Sessao idSessao;

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

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
}
