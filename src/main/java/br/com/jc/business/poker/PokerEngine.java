package br.com.jc.business.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import br.com.jc.canonic.model.poker.Carta;
import br.com.jc.canonic.model.poker.CartaNaipe;
import br.com.jc.canonic.model.poker.CartaValor;
import br.com.jc.canonic.model.poker.Jogada;
import br.com.jc.canonic.model.poker.Mesa;

public class PokerEngine implements Serializable {

	private static final long serialVersionUID = 1811566192545746664L;

	private final int QUANTIDADE_MAXIMA_CARTAS_A_TROCAR = 5;
	
	private Set<Jogada> listaJogadasPossiveis;
	
	private Mesa mesa;
	

	public PokerEngine(Mesa mesa) {
		this.ordernarCartasPorValor(mesa.getMao().getCartas());
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
		ordernarCartasPorValor(cartas);

		straightFlush(cartas);
		fourOfAKing(cartas);
		fullHouse(cartas);
		flush(cartas);
		straight(cartas);
		threeOfAKing(cartas);
		twoPairs(cartas);
		onePair(cartas);
	}
	
	private boolean straightFlush(List<Carta> cartas) {
		if(sequenciaValores(cartas) && sequenciaNaipes(cartas)) {
			listaJogadasPossiveis.add(Jogada.STRAIGHT_FLUSH);
			return true;
		} 
		return false;
	}
	
	private void fourOfAKing(List<Carta> cartas) {
		Map<String, Integer> repeticao = montarCombinacoesJogadas(cartas);
		if(repeticao.size() == 2) {
			Iterator<Integer> iterator = repeticao.values().iterator();
			Integer primeiroGrupo = iterator.next();
			Integer segundoGrupo = iterator.next();
			if((primeiroGrupo == 4 && segundoGrupo == 1) || (primeiroGrupo == 1 && segundoGrupo == 4)) {
				listaJogadasPossiveis.add(Jogada.FOUR_OF_A_KING);
			}
		}
	}
	
	private void fullHouse(List<Carta> cartas) {
		Map<String, Integer> repeticao = montarCombinacoesJogadas(cartas);
		
		if(repeticao.size() == 2) {
			Iterator<Integer> iterator = repeticao.values().iterator();
			Integer primeiroGrupo = iterator.next();
			Integer segundoGrupo = iterator.next();
			if((primeiroGrupo == 3 && segundoGrupo == 2) || (primeiroGrupo == 2 && segundoGrupo == 3)) {
				listaJogadasPossiveis.add(Jogada.FULL_HOUSE);
			}
		}
	}
	
	private void flush(List<Carta> cartas) {
		boolean naipesIguais = true;
		if(!sequenciaValores(cartas)) {
			CartaNaipe naipe = null;
			for(Carta carta : cartas) {
				if(naipe != null && naipe != carta.getNaipe()) {
					naipesIguais = false;
					break;
				}
				naipe = carta.getNaipe();
			}
		} else {
			naipesIguais = false;
		}
		if(naipesIguais)  {
			listaJogadasPossiveis.add(Jogada.FLUSH);
		}
	}
	
	private void straight(List<Carta> cartas) {
		if(sequenciaValores(cartas)) {
			listaJogadasPossiveis.add(Jogada.STRAIGHT);
		}
	}
	
	private void threeOfAKing (List<Carta> cartas) {
		Map<String, Integer> repeticao = montarCombinacoesJogadas(cartas);
		
		if(repeticao.size() == 3) {
			for(Integer grupoQtde : repeticao.values()) {
				if(grupoQtde == 3) {
					listaJogadasPossiveis.add(Jogada.THREE_OF_A_KIND);
				}
			}
		}
	}
	
	private void twoPairs (List<Carta> cartas) {
		Map<String, Integer> repeticao = montarCombinacoesJogadas(cartas);
		if(repeticao.size() == 3) {
			for(Integer grupoQtde : repeticao.values()) {
				if(grupoQtde == 2) {
					listaJogadasPossiveis.add(Jogada.TWO_PAIRS);
				}
			}
		}
	}
	
	private void onePair (List<Carta> cartas) {
		Map<String, Integer> repeticao = montarCombinacoesJogadas(cartas);

		if(repeticao.size() == 4) {
			listaJogadasPossiveis.add(Jogada.ONE_PAIR);
		}
	}	
	
	
	
	private boolean sequenciaValores (List<Carta> cartas) {
		return sequenciaNormalizadaValores(cartas) || sequenciaRoyalValores(cartas);
	}
	
	private boolean sequenciaNormalizadaValores (List<Carta> cartas) {
		Integer sequenciaAnterior = null;
		for(Carta carta : cartas) {
			if(sequenciaAnterior != null) {
				if((sequenciaAnterior+1) != carta.getValor().getOrdem()) {
					return false;
				}
			}
			sequenciaAnterior = carta.getValor().getOrdem();
		}
		return true;
	}
	
	private boolean sequenciaRoyalValores (List<Carta> cartas) {
		if(cartas.get(0).getValor() == CartaValor.AS && 
				cartas.get(1).getValor() == CartaValor.DEZ && 
				cartas.get(2).getValor() == CartaValor.VALETE && 
				cartas.get(3).getValor() == CartaValor.DAMA && 
				cartas.get(4).getValor() == CartaValor.REI) {
			return true;
		}
		return false;
	}
	
	private boolean sequenciaNaipes (List<Carta> cartas) {
		CartaNaipe naipe = null;
		
		for(Carta carta : cartas) {
			if(naipe !=  null) {
				if(naipe != carta.getNaipe()) {
					return false;
				}
			}
			naipe = carta.getNaipe();
		}
		return true;		
	}
	
	private Map<String, Integer> montarCombinacoesJogadas (List<Carta> cartas) {
		Map<String, Integer> repeticao = new HashMap<String, Integer>();
		
		for(Carta carta : cartas) {
			if (repeticao.containsKey(carta.getValor().getValorExibicao())) {
				Integer qtde = repeticao.get(carta.getValor().getValorExibicao());
				repeticao.put(carta.getValor().getValorExibicao(), qtde+1);				
			} else {
				repeticao.put(carta.getValor().getValorExibicao(), 1);
			}
		}
		
		return repeticao;
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
			return Jogada.HIGHEST_CARD;
		}
	}
		
	private static void montarCombinacao(List<Carta> cartasCombinacao, int inicio, int fim, int indiceCartaTrocada, int qtdeCartasRevezando, Carta[] resultado, List<String> listaCartas) {
	    if ( (indiceCartaTrocada + 1) >= qtdeCartasRevezando) {  
	        for(int i = inicio; i <= fim; i++) {  
	            resultado[indiceCartaTrocada] = cartasCombinacao.get(i);
	            listaCartas.add(StringUtils.join(resultado, "-"));
	        }  
	    } else {  
	        for(int i = inicio; i <= fim; i++) {  
	            resultado[indiceCartaTrocada] = cartasCombinacao.get(i);  
	            montarCombinacao(cartasCombinacao, i + 1, fim + 1, indiceCartaTrocada + 1, qtdeCartasRevezando, resultado, listaCartas);  
	        }  
	    }
	}  
	
	private void ordernarCartasPorValor(List<Carta> cartas) {
		Collections.sort(cartas);
	}
	

	public Set<Jogada> listarJogadasEncontradas() {
		return listaJogadasPossiveis;
	}
	
    
}
