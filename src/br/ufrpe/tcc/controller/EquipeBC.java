package br.ufrpe.tcc.controller;

import java.util.List;

import br.ufrpe.tcc.model.Equipe;
import br.ufrpe.tcc.model.repositorio.EquipeDAO;

public class EquipeBC {
	
	private EquipeDAO dao;
	
	public void inserir(Equipe equipe){
		getDao().inserir(equipe);
	}
	
	public void alterar(Equipe equipe){
		getDao().alterar(equipe);
	}
	
	public void excluir(Equipe equipe){
		getDao().excluir(equipe.getId());
	}
	
	public List<Equipe> listar(){
		return getDao().listarEquipe();
	}
	
	public EquipeDAO getDao() {
		if(dao == null){
			dao = new EquipeDAO();
		}
		return dao;
	}

	public void setDao(EquipeDAO dao) {
		this.dao = dao;
	}
	
}
