package br.com.jc.business;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.jc.business.poker.Dealer;
import br.com.jc.business.poker.PokerEngine;
import br.com.jc.canonic.model.poker.Baralho;
import br.com.jc.canonic.model.poker.Carta;
import br.com.jc.canonic.model.poker.CartaNaipe;
import br.com.jc.canonic.model.poker.CartaValor;
import br.com.jc.canonic.model.poker.Jogada;
import br.com.jc.canonic.model.poker.Mao;
import br.com.jc.canonic.model.poker.Mesa;

public class PokerEngineTest {
	

	@Test
	public void royalStraightFlush() {
		String sequenciaCartas = "TH JH QC QD QS QH KH AH 2S 6S";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.STRAIGHT_FLUSH, melhorJogada);
	}

	
	@Test
	public void straightFlush() {
		String sequenciaCartas = "TH JH QC QD QS QH KH 9H 2S 6S";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.STRAIGHT_FLUSH, melhorJogada);
	}
	
	
	@Test
	public void fourOfAKind() {
		String sequenciaCartas = "2H 2S 3H 3S 3C 2D 3D 6C 9C TH";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.FOUR_OF_A_KING, melhorJogada);
	}

	
	@Test
	public void fullHouse() {
		String sequenciaCartas = "2H 2S 3H 3S 3C 2D 9C 3D 6C TH";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.FULL_HOUSE, melhorJogada);
	}
	

	@Test
	public void flush() {
		String sequenciaCartas = "2H AD 5H AC 7H AH 6H 9H 4H 3C";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.FLUSH, melhorJogada);
	}

	
	@Test
	public void straight() {
		String sequenciaCartas = "AC 2D 9C 3S KD 5S 4D KS AS 4C";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.STRAIGHT, melhorJogada);
	}
	
	
	@Test
	public void threeOfAKink() {
		String sequenciaCartas = "KS AH 2H 3C 4H KC 2C TC 2D AS";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.THREE_OF_A_KIND, melhorJogada);
	}
	
	
	@Test
	public void twoPairs() {
		List<Carta> cartasMao = new ArrayList<Carta>();
		Carta carta = new Carta(CartaValor.DOIS, CartaNaipe.OURO);
		cartasMao.add(carta);
		carta = new Carta(CartaValor.QUATRO, CartaNaipe.OURO);
		cartasMao.add(carta);
		carta = new Carta(CartaValor.OITO, CartaNaipe.PAUS);
		cartasMao.add(carta);
		carta = new Carta(CartaValor.VALETE, CartaNaipe.ESPADA);
		cartasMao.add(carta);
		carta = new Carta(CartaValor.REI, CartaNaipe.ESPADA);
		cartasMao.add(carta);
		Mao mao = new Mao(cartasMao);
		
		
		List<Carta> cartasBaralho = new ArrayList<Carta>();
		carta = new Carta(CartaValor.CINCO, CartaNaipe.COPAS);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.VALETE, CartaNaipe.PAUS);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.TRES, CartaNaipe.COPAS);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.DAMA, CartaNaipe.COPAS);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.VALETE, CartaNaipe.OURO);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.NOVE, CartaNaipe.ESPADA);
		cartasBaralho.add(carta);
		carta = new Carta(CartaValor.CINCO, CartaNaipe.PAUS);
		cartasBaralho.add(carta);
		
		Baralho baralho = new Baralho(cartasBaralho);
		
		Mesa mesa = new Mesa(mao, baralho);
		
		PokerEngine engine = new PokerEngine(mesa);
		
		Jogada melhorJogada = engine.jogar();
		
		Assert.assertEquals(Jogada.ONE_PAIR, melhorJogada);
	}

	
	@Test
	public void onePair() {
		String sequenciaCartas = "6C 9C 8C 2D 7C 2H TC 4C 9S AH";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.ONE_PAIR, melhorJogada);

	}

	
	@Test
	public void highCard() {
		String sequenciaCartas = "3D 5S 2H QD TD 6S KH 9H AD QH";
		List<Carta> cartas = new ArrayList<Carta>();
		for(String carta : sequenciaCartas.split(" ")) {
			cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
		}
		Baralho baralho = new Baralho(cartas);
		Mesa mesa = new Dealer.Build().darCartas(baralho);
		PokerEngine engine = new PokerEngine(mesa);
		Jogada melhorJogada = engine.jogar();
		Assert.assertEquals(Jogada.HIGHEST_CARD, melhorJogada);

	}

}
