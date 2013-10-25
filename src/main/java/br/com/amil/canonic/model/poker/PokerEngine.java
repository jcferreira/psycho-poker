package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class PokerEngine implements Serializable {

	private static final long serialVersionUID = 1811566192545746664L;

	private final Integer SEQUENCIA_DEFAULT = 5;
	
	public void abrirCartasNaMesa(Mesa mesa) {
    	System.out.println("M‹o: " + StringUtils.join(mesa.getMao().getCartas(), " "));
    }
	
	public Jogada jogar (Mao deque, Baralho baralho) {
		
		return this.jogar(deque, baralho.getCartas(), SEQUENCIA_DEFAULT);
	}
	
	public Jogada jogar (Mao deque, List<Carta> cartaBaralho, Integer sequencia) {
		
		
		return Jogada.FLUSH;
	}
	
	
	public void orderCartasPorValor(List<Carta> cartas) {
		Collections.sort(cartas);
	}
    
}
