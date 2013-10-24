package br.com.amil.canonic.model.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	
    
    public static class Build {
    	
    	public Build embaralhar(Baralho baralho) {
    		baralho.getCartas();
    		Collections.shuffle(baralho.getCartas());
    		return this;
    	}
    	
    	public List<Carta> darCartas(Baralho baralho) {
    		List<Carta> cartasMao = new ArrayList<Carta>();
    		for(int ordemDaCarta = 0 ; ordemDaCarta < 5 ; ordemDaCarta++) {
    			cartasMao.add(baralho.getCartas().get(ordemDaCarta));
    			baralho.getCartas().remove(ordemDaCarta);
    		}
    		
    		return cartasMao;
    	}
    }
    
    
}