package br.com.jc.leituracartas.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.jc.canonic.model.poker.Baralho;
import br.com.jc.canonic.model.poker.Carta;
import br.com.jc.canonic.model.poker.CartaNaipe;
import br.com.jc.canonic.model.poker.CartaValor;
import br.com.jc.canonic.model.poker.Mao;
import br.com.jc.canonic.model.poker.Mesa;

public class LeituraDeCartas implements Serializable {
	
	private static final long serialVersionUID = -7759707524809449878L;

	public List<Baralho> carregarPorArquivo() {
		
		return null;
	}
    
	public List<Baralho> carregarPorDigitacao() {
		List<Baralho> baralhos = new ArrayList<Baralho>();
		List<String> sequenciasCartasDigitadas = new ArrayList<String>();
		
		sequenciasCartasDigitadas.add("TH JH QC QD QS QH KH AH 2S 6S");
		sequenciasCartasDigitadas.add("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");  
		sequenciasCartasDigitadas.add("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");  
		sequenciasCartasDigitadas.add("2H AD 5H AC 7H AH 6H 9H 4H 3C");
		sequenciasCartasDigitadas.add("AC 2D 9C 3S KD 5S 4D KS AS 4C");
		sequenciasCartasDigitadas.add("KS AH 2H 3C 4H KC 2C TC 2D AS");
		sequenciasCartasDigitadas.add("AH 2C 9S AD 3C QH KS JS JD KD");
		sequenciasCartasDigitadas.add("6C 9C 8C 2D 7C 2H TC 4C 9S AH");
		sequenciasCartasDigitadas.add("3D 5S 2H QD TD 6S KH 9H AD QH");
		
		for(String sequencia : sequenciasCartasDigitadas) {
			List<Carta> cartas = new ArrayList<Carta>();
			for(String carta : sequencia.split(" ")) {
				cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
			}
			baralhos.add(new Baralho(cartas));
		}
		
		return baralhos;
	}
    
}
