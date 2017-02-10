package br.ufrpe.tcc.controller;

import java.util.List;
import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.repositorio.OrganizacaoDAO;

public class OrganizacaoBC {

	private OrganizacaoDAO dao;
	
	public void inserir(Organizacao organizacao){
		getDao().inserir(organizacao);
	}
	
	public void alterar(Organizacao organizacao){
		getDao().alterar(organizacao);
	}
	
	public void excluir(Organizacao organizacao){
		getDao().excluirOrganizacao(organizacao.getId());
	}
	
	public List<Organizacao> listar(){
		return getDao().listarOrganizacao();
	}
	
	public Organizacao buscarOrganizacao(String nome, String senha){
		return getDao().buscarOrganizacao(nome, senha);
	}
	
	public OrganizacaoDAO getDao() {
		if(dao == null){
			dao = new OrganizacaoDAO();
		}
		return dao;
	}

	public void setDao(OrganizacaoDAO dao) {
		this.dao = dao;
	}
}
