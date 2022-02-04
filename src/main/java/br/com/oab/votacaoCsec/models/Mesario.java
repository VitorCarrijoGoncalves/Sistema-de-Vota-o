package br.com.oab.votacaoCsec.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.danielfariati.annotation.CPF;
import com.sun.istack.NotNull;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "Mesario")
public class Mesario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;
	
	@NotNull
	@CPF(required = true, message = "CPF inválido")
	private String cpf;

	@NotNull
	private String login;

	@NotNull
	private String senha;

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
}
