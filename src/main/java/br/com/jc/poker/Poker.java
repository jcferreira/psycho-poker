package br.com.jc.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
		int opcaoEscolhida = obterOpcaoMenu(args);

		
		switch (opcaoEscolhida) {
			case 1:
				obterBaralhoPorDigitacao(mesas);
				break;
			case 2:
				obterBaralhoPorArquivo(mesas);
				break;
			case 3:
				obterBaralhoPorLinhasDigitadasNaClasse(mesas);
				break;
			case 4:
				obterMesasCompletaAleatorio(mesas);
				break;
			default:
				System.out.println("  <<<<<  VALOR DIGITADO ƒ INVçLIDO  >>>>>");
				break;
		}
		
		
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
	
	
	private static List<Mesa> obterBaralhoPorDigitacao(List<Mesa> mesas) {
		LeituraDeCartas leituraBaralho = new LeituraDeCartas();
		List<Baralho> baralhos = leituraBaralho.carregarPorDigitacao();
		for(Baralho baralho : baralhos) {
			mesas.add(new Dealer.Build().darCartas(baralho));
		}
		return mesas;
	}
	
	private static List<Mesa> obterMesasCompletaAleatorio(List<Mesa> mesas) {
		Baralho baralho = new Baralho();
		mesas.add(new Dealer.Build().embaralhar(baralho).darCartas(baralho));
		return mesas;
	}
	
	private static List<Mesa> obterBaralhoPorLinhasDigitadasNaClasse(List<Mesa> mesas) {
		LeituraDeCartas leituraBaralho = new LeituraDeCartas();
		List<Baralho> baralhos = leituraBaralho.carregarPorDigitacaoNaClasse();
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
	
	
	private static int obterOpcaoMenu(String[] args) {
		int opcao = 0;
		
		System.out.println("******************************************************************");
		System.out.println("");
		System.out.println(" Escolha um nœmero de acordo com as op›es abaixo: ");
		System.out.println("");
		System.out.println(" 1 - Entrada de sequncia de cartas por digita‹o");
		System.out.println(" 2 - Leitura de sequncia de cartas por arquivo no diret—rio raiz do projeto (CARTAS.TXT)");
		System.out.println(" 3 - Leitura de sequncia de cartas digitadas na classe java.");
		System.out.println(" 4 - Gerar sequncia aleat—ria autom‡tica de cartas.");
		System.out.println(" ");
		System.out.println("******************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println(" >>>>>>>>>>>>>>>>>>>> ");

		Scanner entrada = new Scanner(System.in);
        try {
        	opcao = Integer.parseInt(entrada.nextLine()); 
        } catch(Exception ex) {
        	System.out.println(" <<<<<  VALOR DIGITADO INVçLIDO  >>>>>");
        	System.exit(0);
        }
		return opcao; 
	}

}

