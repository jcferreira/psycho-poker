package br.com.amil.canonic.model.poker;

import java.io.Serializable;

import lombok.Getter;

public @Getter class Mesa implements Serializable {

	private static final long serialVersionUID = 2518357968774389242L;
	
	private Mao mao;
	
	private Baralho baralho;
	
    public Mesa(Mao mao, Baralho baralho) {
		this.mao = mao;
		this.baralho = baralho;
	}
}
