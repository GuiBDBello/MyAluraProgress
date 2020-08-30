package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}
	
	public void dobraLance(Usuario usuario) {
		if(lances.size() > 0 && podeDarLance(usuario)) {
			Lance ultimo = ultimoLanceDo(usuario);
			propoe(new Lance(usuario, ultimo.getValor() * 2));
		}
	}
	
	private Lance ultimoLanceDo(Usuario usuario) {
        Lance ultimo = null;
        for(Lance lance : lances) {
            if(lance.getUsuario().equals(usuario)) ultimo = lance;
        }

        return lances.get(qtdDeLancesDo(usuario)-1);
    }

	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario) && qtdDeLancesDo(usuario) < 5;
	}

	private int qtdDeLancesDo(Usuario usuario) {
		int total = 0;
		for(Lance l : lances) {
			if(l.getUsuario().equals(usuario)) total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}
