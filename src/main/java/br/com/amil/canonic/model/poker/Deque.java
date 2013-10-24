package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;

public @Getter class Deque implements Serializable {

	private static final long serialVersionUID = -4518392088972922517L;
	

	private List<Carta> cartas;
	
	public Deque(List<Carta> cartas) {
		this.cartas = cartas;
	}

}
