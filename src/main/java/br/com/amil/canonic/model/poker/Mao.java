package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Getter;

public @Getter class Mao implements Serializable {

	private static final long serialVersionUID = -4518392088972922517L;
	

	private List<Carta> cartas;
	
	public Mao(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	@Override
	public String toString() {
		return StringUtils.join(cartas, " ");
	}
	
}
