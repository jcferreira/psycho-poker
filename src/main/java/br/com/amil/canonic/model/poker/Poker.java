package br.com.amil.canonic.model.poker;

import org.apache.commons.lang.StringUtils;


public class Poker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		
		Mesa mesa = new Dealer.Build().embaralhar(baralho).darCartas(baralho);
		

		PokerEngine engine = new PokerEngine();
		engine.abrirCartasNaMesa(mesa);
		
		
		
		imprimir(mesa);
	}
	
	private static void imprimir(Mesa mesa) {
		System.out.println("#####################################");
		
		PokerEngine engine = new PokerEngine();
		System.out.println("Cartas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		engine.orderCartasPorValor(mesa.getMao().getCartas());
		System.out.println("Cartas Ordenadas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		
		System.out.println("#####################################");
	}

}

