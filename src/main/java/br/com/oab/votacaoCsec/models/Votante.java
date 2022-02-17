package br.com.oab.votacaoCsec.models;

import javax.persistence.*;

import com.danielfariati.annotation.CPF;
import com.sun.istack.NotNull;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "votante")
public class Votante {
	
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
	@ManyToOne
	private OpcaoVoto voto;

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

	public OpcaoVoto getVoto() {
		return voto;
	}

	public void setVoto(OpcaoVoto voto) {
		this.voto = voto;
	}
}
