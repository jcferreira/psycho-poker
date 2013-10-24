package br.com.amil.canonic.model.poker;

import java.util.List;

public class Poker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("xxxx");
		Baralho baralho = new Baralho();
		baralho.abrirCartasNaMesa();
		
		List<Carta> cartasMao = new Dealer.Build().embaralhar(baralho).darCartas(baralho);
		
		//new Dealer.Build().embaralhar(baralho);
		//baralho.abrirCartasNaMesa();
		
		
	}

}

