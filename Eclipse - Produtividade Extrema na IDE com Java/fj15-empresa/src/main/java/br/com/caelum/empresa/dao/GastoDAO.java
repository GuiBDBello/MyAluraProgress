package br.com.caelum.empresa.dao;

import java.util.List;

//import org.apache.log4j.Logger;

import br.com.caelum.empresa.modelo.Gasto;

public class GastoDAO {
	private DAO<Gasto> dao = new DAO<Gasto>(Gasto.class);
	
	//private static final Logger logger = Logger.getLogger(GastoDAO.class);
	
	public void adiciona(Gasto entity) {
		dao.adiciona(entity);
	}

	public void remove(Gasto entity) {
		dao.remove(entity);
	}

	public Gasto buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public List<Gasto> buscaTodos() {
		return dao.buscaTodos();
	}
	
}