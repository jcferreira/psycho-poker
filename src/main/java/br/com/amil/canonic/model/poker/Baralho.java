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
    
    public void abrirCartasNaMesa() {
    	int i = 0;
    	for(Carta carta : cartas) {
    		i++;
    		System.out.println("Carta " + i + ":" + carta);
    	}
    }
    
    
    private void montarBaralho() {
    	this.cartas = new ArrayList<Carta>();
    	/*
    	for(int valor=2; valor<=10; valor++) {
    		this.cartas.add(new Carta(Integer.toString(valor), "C"));
    		this.cartas.add(new Carta(Integer.toString(valor), "D"));
    		this.cartas.add(new Carta(Integer.toString(valor), "S"));
    		this.cartas.add(new Carta(Integer.toString(valor), "H"));
    	}
    	this.cartas.add(new Carta("A", "C"));
    	this.cartas.add(new Carta("A", "D"));
    	this.cartas.add(new Carta("A", "S"));
    	this.cartas.add(new Carta("A", "H"));
    	
    	this.cartas.add(new Carta("J", "C"));
    	this.cartas.add(new Carta("J", "D"));
    	this.cartas.add(new Carta("J", "S"));
    	this.cartas.add(new Carta("J", "H"));
    	
    	this.cartas.add(new Carta("Q", "C"));
    	this.cartas.add(new Carta("Q", "D"));
    	this.cartas.add(new Carta("Q", "S"));
    	this.cartas.add(new Carta("Q", "H"));
    	
    	this.cartas.add(new Carta("K", "C"));
    	this.cartas.add(new Carta("K", "D"));
    	this.cartas.add(new Carta("K", "S"));
    	this.cartas.add(new Carta("K", "H"));
    	*/
    	
    	
    	for(CartaValor valor : CartaValor.values()) {
    		for(CartaNaipe naipe : CartaNaipe.values()) {
    			this.cartas.add(new Carta(valor, naipe));
    		}
    	}
    }
    
    
    
    
    
}
