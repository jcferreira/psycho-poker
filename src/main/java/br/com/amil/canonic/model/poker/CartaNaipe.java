package br.com.amil.canonic.model.poker;

import java.io.Serializable;

import lombok.Getter;

public @Getter enum CartaNaipe implements Serializable{
	
	PAUS (1, "C"),
	OURO (2, "D"),
	ESPADA (3, "S"),
	COPAS (4, "H");

	
	private Integer indice;
	private String valorExibicao;
	
	CartaNaipe(Integer indice, String valorExibicao) {
		this.indice = indice;
		this.valorExibicao = valorExibicao;
	}
	
	@Override
	public String toString() {
		return this.valorExibicao;
	}

}




