package br.com.jc.leituracartas.poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.jc.canonic.model.poker.Baralho;
import br.com.jc.canonic.model.poker.Carta;
import br.com.jc.canonic.model.poker.CartaNaipe;
import br.com.jc.canonic.model.poker.CartaValor;

public class LeituraDeCartas implements Serializable {
	
	private static final long serialVersionUID = -7759707524809449878L;

	
	public List<Baralho> carregarPorDigitacao() {
		List<Baralho> baralhos = new ArrayList<Baralho>();
		List<String> sequenciasCartasDigitadas = new ArrayList<String>();

		sequenciasCartasDigitadas.add("TH JH QC QD QS QH KH AH 2S 6S");  //Melhor Jogo: royal-straight-flush (sequência numérica e de naipe)
		sequenciasCartasDigitadas.add("TH JH QC QD QS QH KH 9H 2S 6S");  //Melhor Jogo: straight-flush (sequência numérica)
		sequenciasCartasDigitadas.add("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");  //Melhor Jogo: four-of-a-kind (quadra)  
		sequenciasCartasDigitadas.add("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");  //Melhor Jogo: full-house (trinca + par)  
		sequenciasCartasDigitadas.add("2H AD 5H AC 7H AH 6H 9H 4H 3C");  //Melhor Jogo: flush (sequência de naipe)
		sequenciasCartasDigitadas.add("AC 2D 9C 3S KD 5S 4D KS AS 4C");  //Melhor Jogo: straight (sequência numérica)
		sequenciasCartasDigitadas.add("KS AH 2H 3C 4H KC 2C TC 2D AS");  //Melhor Jogo: three-of-a-kind (trinca)
		sequenciasCartasDigitadas.add("AH 2C 9S AD 3C QH KS JS JD KD");  //Melhor Jogo: two-pairs (2 pares)
		sequenciasCartasDigitadas.add("6C 9C 8C 2D 7C 2H TC 4C 9S AH");  //Melhor Jogo: one-pair (1 par)
		sequenciasCartasDigitadas.add("3D 5S 2H QD TD 6S KH 9H AD QH");  //Melhor Jogo: highest-card (maior carta)
		
		
		for(String sequencia : sequenciasCartasDigitadas) {
			List<Carta> cartas = new ArrayList<Carta>();
			for(String carta : sequencia.split(" ")) {
				cartas.add(new Carta(CartaValor.fromCarta(carta), CartaNaipe.fromCarta(carta)));
			}
			baralhos.add(new Baralho(cartas));
		}
		
		return baralhos;
	}

	
	public List<Baralho> carregarPorArquivo() {
		
		List<Baralho> baralhos = new ArrayList<Baralho>();
		List<String> sequenciasCartasDigitadas = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("CARTAS.TXT"));  
			String linha = "";
			while ((linha = reader.readLine()) != null) {
	    		sequenciasCartasDigitadas.add(linha);
		    }  
		    reader.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
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
