package br.com.jc.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import br.com.jc.business.poker.Dealer;
import br.com.jc.business.poker.PokerEngine;
import br.com.jc.canonic.model.poker.Baralho;
import br.com.jc.canonic.model.poker.Jogada;
import br.com.jc.canonic.model.poker.Mesa;
import br.com.jc.leituracartas.poker.LeituraDeCartas;


public class Poker implements Serializable{

	private static final long serialVersionUID = -2761559977331824483L;
	

	public static void main(String[] args) {
		
		List<Mesa> mesas = new ArrayList<Mesa>();
		//mesas.addAll(obterMesasCompletoAleatorio(mesas));
		mesas.addAll(obterBaralhoPorLinhasDigitadas(mesas));
		//mesas.addAll(obterBaralhoPorArquivo(mesas));
		
		for(Mesa mesa : mesas) {
			//imprimir(mesa);

			String mensagem = "M‹o: " + mesa.getMao().getCartas() + " Monte: " + mesa.getBaralho().olharCartas(5);
			PokerEngine engine = new PokerEngine(mesa);
			//engine.abrirCartasNaMesa();

			Jogada melhorJogada = engine.jogar();
			System.out.println("********************************************************************************** ");
			System.out.println(mensagem + " Melhor Jogo: " + melhorJogada);
			System.out.println("********************************************************************************** \n");
			
			//listarTodasJogadasEncontradas(engine.listarJogadasEncontradas());
		}

	}
	
	
	private static List<Mesa> obterMesasCompletoAleatorio(List<Mesa> mesas) {
		Baralho baralho = new Baralho();
		mesas.add(new Dealer.Build().embaralhar(baralho).darCartas(baralho));
		return mesas;
	}
	
	private static List<Mesa> obterBaralhoPorLinhasDigitadas(List<Mesa> mesas) {
		LeituraDeCartas leituraBaralho = new LeituraDeCartas();
		List<Baralho> baralhos = leituraBaralho.carregarPorDigitacao();
		for(Baralho baralho : baralhos) {
			mesas.add(new Dealer.Build().darCartas(baralho));
		}
		return mesas;
	}
	
	private static List<Mesa> obterBaralhoPorArquivo(List<Mesa> mesas) {
		LeituraDeCartas leituraBaralho = new LeituraDeCartas();
		List<Baralho> baralhos = leituraBaralho.carregarPorArquivo();
		for(Baralho baralho : baralhos) {
			mesas.add(new Dealer.Build().darCartas(baralho));
		}
		return mesas;
	}
	
	
	
	private static void imprimir(Mesa mesa) {
		System.out.println("#####################################");
		
		System.out.println("Cartas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		PokerEngine engine = new PokerEngine(mesa);
		System.out.println("Cartas Ordenadas: " + StringUtils.join(mesa.getMao().getCartas(), " "));
		
		System.out.println("#####################################");
	}
	
	private static void listarTodasJogadasEncontradas(Set<Jogada> listarJogadasEncontradas) {
		for (Jogada jogada : listarJogadasEncontradas) {
			System.out.println(" >>>>>>> Indice: " + jogada.getOrdemMelhorJogada() + "  -  Jogada: " + jogada);
		}
	}

}

