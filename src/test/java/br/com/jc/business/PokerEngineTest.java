package br.com.jc.business;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

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
	public void test() {
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

}
