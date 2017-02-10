package br.ufrpe.tcc.fachada;

import java.util.List;

import br.ufrpe.tcc.controller.EquipeBC;
import br.ufrpe.tcc.controller.EspecificacaoBC;
import br.ufrpe.tcc.controller.OrganizacaoBC;
import br.ufrpe.tcc.controller.ProjetoBC;
import br.ufrpe.tcc.model.Equipe;
import br.ufrpe.tcc.model.Especificacao;
import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.Projeto;

public class Fachada {
	
	private EquipeBC equipeBC;
	private EspecificacaoBC especBC;
	private ProjetoBC projetoBC;
	private OrganizacaoBC organizacaoBC;
	
	public Fachada() {
		equipeBC = new EquipeBC();
		especBC = new EspecificacaoBC();
		projetoBC = new ProjetoBC();
		organizacaoBC = new OrganizacaoBC();
	}
	//Equipe
	public EquipeBC getEquipeBC(){
		return equipeBC;
	}
	public void setEquipeBC(EquipeBC equipeBC) {
		this.equipeBC = equipeBC;
	}
	
	public void inserirEquipe(Equipe equipe){
		getEquipeBC().inserir(equipe);
	}
	
	public void alterarEquipe(Equipe equipe){
		getEquipeBC().alterar(equipe);
	}
	
	public void excluirEquipe(Equipe equipe){
		getEquipeBC().excluir(equipe);
	}
	
	public List<Equipe> listarEquipe(){
		return equipeBC.listar();
	}
	
	//Especificaçao
	
	public EspecificacaoBC getEspecBC() {
		return especBC;
	}
	public void setEspecBC(EspecificacaoBC especBC) {
		this.especBC = especBC;
	}
	
	public void inserirEspecificacao(Especificacao 
			especificacao){
		getEspecBC().inserir(especificacao);
	}
	
	public void alterarEspecificacao(Especificacao 
			especificacao){
		getEspecBC().alterar(especificacao);
	}
	
	public void excluirEspecificacao(Especificacao 
			especificacao){
		getEspecBC().excluir(especificacao);
	}
	
	public List<Especificacao> listarEspecificacao(){
		return especBC.listar();
	}
	
	//Projeto
	
	public ProjetoBC getProjetoBC() {
		return projetoBC;
	}
	public void setProjetoBC(ProjetoBC projetoBC) {
		this.projetoBC = projetoBC;
	}
	
	public void inserirProjeto(Projeto projeto){
		getProjetoBC().inserir(projeto);
	}
	
	public void alterarProjeto(Projeto projeto){
		getProjetoBC().alterar(projeto);
	}
	
	public void excluirProjeto(Projeto projeto){
		getProjetoBC().excluir(projeto);
	}
	public List<Projeto> buscarProjetos(Organizacao org, String nomeProjeto, String responsavel){
		return projetoBC.buscarProjetos(org, nomeProjeto, responsavel);
	}
	public List<Projeto> listarProjeto(){
		return projetoBC.listar();
	}
	
	//Organizacao
	public OrganizacaoBC getOrganizacaoBC(){
		return organizacaoBC;
	}
	public void setOrganizacaoBC(OrganizacaoBC organizacaoBC){
		this.organizacaoBC = organizacaoBC;
	}
	public void inserirOrganizacao(Organizacao organizacao){
		getOrganizacaoBC().inserir(organizacao);
	}
	public void alterarOrganizacao(Organizacao organizacao){
		getOrganizacaoBC().alterar(organizacao);
	}
	public void excluirOrganizacao(Organizacao organizacao){
		getOrganizacaoBC().excluir(organizacao);
	}
	public List<Organizacao> listarOrganizacao(){
		return organizacaoBC.listar();
	}
	public Organizacao buscarOrganizacao(String nome, String senha){
		return organizacaoBC.buscarOrganizacao(nome, senha);
	}
}
