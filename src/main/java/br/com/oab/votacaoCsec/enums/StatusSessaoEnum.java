package br.com.oab.votacaoCsec.enums;

public enum StatusSessaoEnum {
	
	AINICIAR("A Iniciar"),
	EMANDAMENTO("Em Andamento"),
	EMVOTACAO("Em Votação"),
	FINALIZADA("Finalizada");
	
	private String descricao;

	StatusSessaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
