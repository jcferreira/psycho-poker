package br.com.amil.canonic.model.poker;

import java.io.Serializable;

import lombok.Getter;

public @Getter enum Jogada implements Serializable{
	
	STRAIGHT_FLUSH (1, "Sequência numérica e de naipe"),
	FOUR_OF_A_KING (2, "Quadra"),
	FULL_HOUSE (3, "Trinca + par"),
	FLUSH (4, "Sequência de naipe"),
	STRAIGHT (5, "Sequência numérica"),
	THREE_OF_A_KIND (6, "Trinca"),
	TWO_PAIRS (7, "Dois pares"),
	ONE_PAIR (8, "Um Par"),
	HIGHEST_CARD (9, "Maior Carta");
	  
	
	private Integer ordemMelhorJogada;
	private String descricao;
	
	Jogada(Integer ordemMelhorJogada, String descricao) {
		this.ordemMelhorJogada = ordemMelhorJogada;
		this.descricao = descricao;
	}
	
	

}




