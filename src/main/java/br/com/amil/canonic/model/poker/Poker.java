package br.com.amil.canonic.model.poker;

import org.apache.commons.lang.StringUtils;


public class Poker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		
		Mesa mesa = new Dealer.Build().embaralhar(baralho).darCartas(baralho);
		
		imprimir(mesa);

		
		PokerEngine engine = new PokerEngine(mesa);
		//engine.abrirCartasNaMesa();
		
		
		
		
		
	}
	
	private static void imprimir(Mesa mesa) {
		System.out.println("#####################################");
		
		System.out.println("Cartas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		PokerEngine engine = new PokerEngine(mesa);
		System.out.println("Cartas Ordenadas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		
		System.out.println("#####################################");
	}

}

