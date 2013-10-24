package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.List;

public class PokerEngine implements Serializable {

	private static final long serialVersionUID = 1811566192545746664L;

	private final Integer SEQUENCIA_DEFAULT = 5;
	
	
	public Jogada jogar (Deque deque, Baralho baralho) {
		
		return this.jogar(deque, baralho.getCartas(), SEQUENCIA_DEFAULT);
	}
	
	public Jogada jogar (Deque deque, List<Carta> cartaBaralho, Integer sequencia) {
		
		
		return Jogada.FLUSH;
	}
	
	
    
}