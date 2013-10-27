package br.com.jc.canonic.model.poker;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;

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
