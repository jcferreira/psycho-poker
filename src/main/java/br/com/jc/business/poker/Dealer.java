package br.com.jc.business.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.jc.canonic.model.poker.Baralho;
import br.com.jc.canonic.model.poker.Carta;
import br.com.jc.canonic.model.poker.Mao;
import br.com.jc.canonic.model.poker.Mesa;

public class Dealer implements Serializable {
	
	private static final long serialVersionUID = -2232102864755639533L;

	public static class Build {
		
    	
    	public Build embaralhar(Baralho baralho) {
    		Collections.shuffle(baralho.getCartas());
    		return this;
    	}
    	
    	public Mesa darCartas(Baralho baralho) {
    		List<Carta> cartasMao = new ArrayList<Carta>();
    		for(int ordemDaCarta = 0 ; ordemDaCarta < 5 ; ordemDaCarta++) {
    			cartasMao.add(baralho.getCartas().get(ordemDaCarta));
    			baralho.getCartas().remove(ordemDaCarta);
    		}
    		
    		return new Mesa(new Mao(cartasMao), baralho);
    	}
    }
    
    
}
