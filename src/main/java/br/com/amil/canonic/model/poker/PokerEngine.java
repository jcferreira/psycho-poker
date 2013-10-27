package br.com.amil.canonic.model.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class PokerEngine implements Serializable {

	private static final long serialVersionUID = 1811566192545746664L;

	private final int QUANTIDADE_MAXIMA_CARTAS_A_TROCAR = 5;
	
	private Set<Jogada> listaJogadasPossiveis;
	
	private Mesa mesa;
	
private int count = 0;
	
	public PokerEngine(Mesa mesa) {
		this.orderCartasPorValor(mesa.getMao().getCartas());
		this.mesa = mesa;
		this.listaJogadasPossiveis = new HashSet<Jogada>();
	}
	
	public void abrirCartasNaMesa() {
    	System.out.println("M‹o: " + StringUtils.join(this.mesa.getMao().getCartas(), " "));
    }
	
	public Jogada jogar() {
		List<Carta> cartasMao = this.mesa.getMao().getCartas();
		
		if (straightFlush(cartasMao)) {
			return Jogada.STRAIGHT_FLUSH;
		}
		
		this.verificarJogadas(cartasMao);
		
		for(int quantidadeCartasOlhadasBaralho=1 ; quantidadeCartasOlhadasBaralho <= QUANTIDADE_MAXIMA_CARTAS_A_TROCAR ; quantidadeCartasOlhadasBaralho++ ) {
			List<String> combinacoesCartas = new ArrayList<String>();
			List<Carta> cartasOlhadas = this.mesa.getBaralho().olharCartas(quantidadeCartasOlhadasBaralho);
			if(quantidadeCartasOlhadasBaralho < QUANTIDADE_MAXIMA_CARTAS_A_TROCAR) {
				montarCombinacao(cartasMao, 0, cartasOlhadas.size(), 0, QUANTIDADE_MAXIMA_CARTAS_A_TROCAR-cartasOlhadas.size(), new Carta[QUANTIDADE_MAXIMA_CARTAS_A_TROCAR-cartasOlhadas.size()], combinacoesCartas);
				List<List<Carta>> listaCartas = this.mesa.getBaralho().getCartaFromString(combinacoesCartas);
				for(List<Carta> cartas : listaCartas) {
					cartas.addAll(cartasOlhadas);
					this.verificarJogadas(cartas);
				}
			} else {
				this.verificarJogadas(cartasOlhadas);
			}
			
			//this.verificarJogadas(this.mesa.getBaralho().getCartaFromString(combinacoesCartas));
		}
		
		return this.melhorJogada();
	}
	

	private void verificarJogadas(List<Carta> cartas) {
		
System.out.println("######======>>>>>  " + count++ + "   |   " + StringUtils.join(cartas, " - "));
		
		straightFlush(cartas);
		fourOfAKing();
	}
	
	private boolean straightFlush(List<Carta> cartas) {
		Integer sequenciaAnterior = null;
		CartaNaipe naipe = null;
		
		for(Carta mao : cartas) {
			if(sequenciaAnterior != null && naipe !=  null) {
				if((sequenciaAnterior+1) != mao.getValor().getOrdem()) {
					return false;
				}
				if(naipe != mao.getNaipe()) {
					return false;
				}
			}
			sequenciaAnterior = mao.getValor().getOrdem();
			naipe = mao.getNaipe();
		}
		
		listaJogadasPossiveis.add(Jogada.STRAIGHT_FLUSH);
		return true;
	}
	
	private void fourOfAKing() {
		
	}
	
	private Jogada melhorJogada() {
		if(listaJogadasPossiveis != null && !listaJogadasPossiveis.isEmpty()) {
			Comparator comparadorJogada = new Comparator<Jogada>() {
	        	public int compare(Jogada j1, Jogada j2) {
	        		return j1.getOrdemMelhorJogada().compareTo(j2.getOrdemMelhorJogada());
	    	  }
	        };
	        Object[] arrayJogadas = listaJogadasPossiveis.toArray();
	        Arrays.sort(arrayJogadas, comparadorJogada);
	        
	        return Jogada.fromValue(String.valueOf(arrayJogadas[0]));
		} else {
			return Jogada.MAO;
		}
	}
		
	private void montarCombinacao(List<Carta> cartasCombinacao, int inicio, int fim, int indiceCartaTrocada, int qtdeCartasRevezando, Carta[] resultado, List<String> listaCartas) {
	    if ( (indiceCartaTrocada + 1) >= qtdeCartasRevezando) {  
	        for(int i = inicio; i <= fim; i++) {  
	            resultado[indiceCartaTrocada] = cartasCombinacao.get(i);
	            listaCartas.add(StringUtils.join(resultado, "-"));
	            //System.out.println(StringUtils.join(resultado, " - ")); 
	        }  
	    } else {  
	        for(int i = inicio; i <= fim; i++) {  
	            resultado[indiceCartaTrocada] = cartasCombinacao.get(i);  
	            montarCombinacao(cartasCombinacao, i + 1, fim + 1, indiceCartaTrocada + 1, qtdeCartasRevezando, resultado, listaCartas);  
	        }  
	    }
	}  
	
	private void orderCartasPorValor(List<Carta> cartas) {
		Collections.sort(cartas);
	}
	

	
	/*************************************************/
	
	
/*
	public static void main(String[] args) {
		
		
		List<Carta> lista1 = new ArrayList<Carta>();
		lista1.add(new Carta(CartaValor.AS, CartaNaipe.COPAS));
		lista1.add(new Carta(CartaValor.DOIS, CartaNaipe.COPAS));
		lista1.add(new Carta(CartaValor.TRES, CartaNaipe.COPAS));
		lista1.add(new Carta(CartaValor.QUATRO, CartaNaipe.COPAS));
		lista1.add(new Carta(CartaValor.CINCO, CartaNaipe.COPAS));
		
		List<Carta> lista2 = new ArrayList<Carta>();
		lista2.add(new Carta(CartaValor.SEIS, CartaNaipe.COPAS));
		lista2.add(new Carta(CartaValor.SETE, CartaNaipe.COPAS));
		lista2.add(new Carta(CartaValor.OITO, CartaNaipe.COPAS));
		
		

		List<String> listaCartas = new ArrayList<String>();
        montarCombinacao(lista1, 0, lista2.size(), 0, 5-lista2.size(), new Carta[5-lista2.size()], listaCartas);
        
        
        for(String c : listaCartas) {
        	System.out.println(" ====>>> " + c);
        }
        
        Set<Jogada> j = new HashSet<Jogada>();
        j.add(Jogada.HIGHEST_CARD);
        j.add(Jogada.STRAIGHT);
        j.add(Jogada.FLUSH);
        j.add(Jogada.FLUSH);
        j.add(Jogada.TWO_PAIRS);
        j.add(Jogada.TWO_PAIRS);
        j.add(Jogada.STRAIGHT_FLUSH);
        j.add(Jogada.FLUSH);
        
        
        Comparator comparator1 = new Comparator<Jogada>() {
        	public int compare(Jogada j1, Jogada j2) {
        		System.out.println(" ### " + j1.getOrdemMelhorJogada().compareTo(j2.getOrdemMelhorJogada()) + "  |  j1: " + j1.getOrdemMelhorJogada() + "-"  + j1 + "  |  j2: " + j2.getOrdemMelhorJogada() + "-" + j2);
        		
        		return j1.getOrdemMelhorJogada().compareTo(j2.getOrdemMelhorJogada());
    	  }
        };
        Object[] array = j.toArray();
        Arrays.sort(array, comparator1);
        
        for(Object obj : array) {
        	Jogada jog = (Jogada) obj;
        	System.out.println("Ordem: " + jog.getOrdemMelhorJogada() + "  |  Jogada: " + jog );
        }
        
        
	}
	
*/	
	  
	
	
	
	
	
	
    
}
