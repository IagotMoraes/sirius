package br.ufrpe.tcc.controller;

import java.util.List;

import br.ufrpe.tcc.model.Especificacao;
import br.ufrpe.tcc.model.repositorio.EspecificacaoDAO;

public class EspecificacaoBC {
	
	private EspecificacaoDAO dao;
	
	public void inserir(Especificacao especificacao){
		getDao().inserir(especificacao);
	}
	
	public void alterar(Especificacao especificacao){
		getDao().alterar(especificacao);
	}
	
	public void excluir(Especificacao especificacao){
		getDao().excluir(especificacao.getId());
	}
	
	public List<Especificacao> listar(){
		return getDao().listarEspecificacao();
	}

	public EspecificacaoDAO getDao() {
		return dao;
	}

	public void setDao(EspecificacaoDAO dao) {
		this.dao = dao;
	}
	
}
