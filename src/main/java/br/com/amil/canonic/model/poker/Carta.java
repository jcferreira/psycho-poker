package br.com.amil.canonic.model.poker;

import java.io.Serializable;

import lombok.Data;

public @Data class Carta implements Serializable {

	private static final long serialVersionUID = 2378489237834723L;
	
	
	public Carta(String valor, String naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	private String valor;
	
	private String naipe;
	

	@Override
	public String toString() {
		return valor.concat(naipe);
	}
}
