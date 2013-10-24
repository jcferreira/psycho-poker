package br.com.amil.canonic.model.poker;


public class Poker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		baralho.abrirCartasNaMesa();
		Deque deque = new Dealer.Build().embaralhar(baralho).darCartas(baralho);
		
		//new Dealer.Build().embaralhar(baralho);
		//baralho.abrirCartasNaMesa();
		
		
	}

}

