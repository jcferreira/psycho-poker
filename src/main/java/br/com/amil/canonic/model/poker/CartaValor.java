package br.com.amil.canonic.model.poker;

import java.io.Serializable;

import lombok.Getter;

public @Getter enum CartaValor implements Serializable{
	
	AS (1, "A"),
	DOIS (2, "2"),
	TRES (3, "3"),
	QUATRO (4, "4"),
	CINCO (5, "5"),
	SEIS (6, "6"),
	SETE (7, "7"),
	OITO (8, "8"),
	NOVE (9, "9"),
	DEZ (10, "T"),
	VALETE (11, "J"),
	DAMA (12, "Q"),
	REI (13, "K");

	
	private Integer ordem;
	private String valorExibicao;
	
	CartaValor(Integer ordem, String valorExibicao) {
		this.ordem = ordem;
		this.valorExibicao = valorExibicao;
	}
	
	@Override
	public String toString() {
		return this.valorExibicao;
	}

}




