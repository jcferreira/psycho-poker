package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

public @Data class Carta implements Serializable, Comparable<Carta> {

	private static final long serialVersionUID = -4850867306399190460L;
	
	private CartaValor valor;
	private CartaNaipe naipe;
	

	public Carta(CartaValor valor, CartaNaipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	

	@Override
	public String toString() {
		return valor.toString() + naipe.toString();
	}

	@Override
	public int compareTo(Carta carta) {
		return this.valor.getOrdem().compareTo(carta.getValor().getOrdem());
	}
}
