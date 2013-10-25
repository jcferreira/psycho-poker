package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public @Getter class Baralho implements Serializable {

	private static final long serialVersionUID = 4727295656949573944L;

	private List<Carta> cartas;
	
    public Baralho() {
    	this.montarBaralho();
	}

    public List<Carta> olharCartas(int quantidadeCartas) {
    	List<Carta> olharCartas = new ArrayList<Carta>();
    	for(int i=0 ; i < quantidadeCartas ; i++) {
    		olharCartas.add(cartas.get(i));
    	}
    	return olharCartas;
    }
    
    private void montarBaralho() {
    	this.cartas = new ArrayList<Carta>();
    	for(CartaValor valor : CartaValor.values()) {
    		for(CartaNaipe naipe : CartaNaipe.values()) {
    			this.cartas.add(new Carta(valor, naipe));
    		}
    	}
    }
    
    
    
    
}
