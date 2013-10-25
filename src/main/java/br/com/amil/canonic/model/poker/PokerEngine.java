package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class PokerEngine implements Serializable {

	private static final long serialVersionUID = 1811566192545746664L;

	private final Integer SEQUENCIA_MAXIMA_CARTAS_A_VERIFICAR = 5;
	
	private Set<Jogada> listaJogadasPossiveis;
	
	private Mesa mesa;
	
	public PokerEngine(Mesa mesa) {
		this.orderCartasPorValor(mesa.getMao().getCartas());
		this.mesa = mesa;
		this.listaJogadasPossiveis = new HashSet<Jogada>();
	}
	
	public void abrirCartasNaMesa() {
    	System.out.println("M‹o: " + StringUtils.join(this.mesa.getMao().getCartas(), " "));
    }
	
	public Set<Jogada> jogar() {
		if (!isStraightFlush()) {
			//verifico outras jogadas, pois se der Straight Flush n‹o preciso verificar mais nenhum caso, pois Ž o maior
			this.verificarFourOfAKing();
		}
		
		
		return listaJogadasPossiveis;
	}

	private boolean isStraightFlush() {
		
		
		return false;
	}
	
	private void verificarFourOfAKing() {
		
	}
	
	private void orderCartasPorValor(List<Carta> cartas) {
		Collections.sort(cartas);
	}
    
}
