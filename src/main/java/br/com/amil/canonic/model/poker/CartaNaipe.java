package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public @Getter enum CartaNaipe implements Serializable{
	
	PAUS (1, "C"),
	OURO (2, "D"),
	ESPADA (3, "S"),
	COPAS (4, "H");

	
	private Integer indice;
	private String valorExibicao;
	
	private static Map<String, CartaNaipe> naipeByChave = new HashMap<String, CartaNaipe>();
	
	static {
        for (CartaNaipe naipe : CartaNaipe.values()) {
        	naipeByChave.put(naipe.getValorExibicao(), naipe);
        }
    }
	
	
	CartaNaipe(Integer indice, String valorExibicao) {
		this.indice = indice;
		this.valorExibicao = valorExibicao;
	}
	
	public static CartaNaipe fromCarta(String cartaStr) {
		return naipeByChave.get(cartaStr);
	}

	@Override
	public String toString() {
		return this.valorExibicao;
	}

}




