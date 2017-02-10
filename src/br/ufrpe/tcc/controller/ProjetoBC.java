package br.ufrpe.tcc.controller;

import java.util.List;

import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.Projeto;
import br.ufrpe.tcc.model.repositorio.ProjetoDAO;

public class ProjetoBC {
	
	private ProjetoDAO dao;
	
	public void inserir(Projeto projeto){
		getDao().inserir(projeto);
	}
	
	public void alterar(Projeto projeto){
		getDao().alterar(projeto);
	}
	
	public void excluir(Projeto projeto){
		getDao().excluirProjeto(projeto.getId());
	}
	
	public List<Projeto> listar(){
		return getDao().listarProjeto();
	}
	
	public List<Projeto> buscarProjetos(Organizacao org, String nomeProjeto, String responsavel){
		return getDao().buscarProjetos(org, nomeProjeto, responsavel);
	}
	
	public ProjetoDAO getDao() {
		if(dao == null){
			dao = new ProjetoDAO();
		}
		return dao;
	}

	public void setDao(ProjetoDAO dao) {
		this.dao = dao;
	}

}
