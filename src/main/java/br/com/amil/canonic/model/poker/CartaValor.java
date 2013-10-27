package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

	private static Map<String, CartaValor> valorByChave = new HashMap<String, CartaValor>();
	
	static {
        for (CartaValor valor : CartaValor.values()) {
        	valorByChave.put(valor.getValorExibicao(), valor);
        }
    }
	
	CartaValor(Integer ordem, String valorExibicao) {
		this.ordem = ordem;
		this.valorExibicao = valorExibicao;
	}
	
	public static CartaValor fromCarta(String cartaStr) {
		return valorByChave.get(cartaStr.subSequence(0, 1));
	}

	@Override
	public String toString() {
		return this.valorExibicao;
	}
	

}




