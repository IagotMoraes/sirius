package br.ufrpe.tcc.view;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.Projeto;

@ManagedBean
@SessionScoped
public class OrganizacaoEditMB {
	private Organizacao organizacao;
	private Fachada fachada;
	private boolean log;
	private String nomeProjeto = "";
	private String responsavel ="";
	
	public boolean isFluxoAlterar(){
		return organizacao.getId() != 0;
	}
	
	@PostConstruct
	private void init(){
		this.organizacao = new Organizacao();
		this.fachada = new Fachada();
		this.log = false;
	}
	
	public void preAlterar(Organizacao organizacao){
		setOrganizacao(organizacao);
	}
	
	public String salvar() throws IOException{
		if(isFluxoAlterar()){
			getFachada().alterarOrganizacao(organizacao);
		}
		else{
			getFachada().inserirOrganizacao(organizacao);
			login();
		}
		return "success";
	}
	
	public Organizacao getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public void login() throws IOException{
		try{
			Organizacao org = fachada.buscarOrganizacao(organizacao.getNome(),
					organizacao.getSenha());
			if (org!=null){
				setOrganizacao(org);
				System.out.println(organizacao.getId()+" - "+org.getNome());
				setLog(true);
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, 
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não encontrado ou senha incorreta, tente novamente.", "Usuario não encontrado ou senha incorreta, tente novamente."));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		if(log){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Organizacao", organizacao);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/listarProjeto.xhtml");
		}
	}
	
	public void logout(){
		try{
			init();
			FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/index.xhtml");
		}
		catch(Exception e){}
	}
	
	public void excluirProjeto(Projeto projeto){
		try{
		organizacao.getProjetos().remove(projeto);
		fachada.excluirProjeto(projeto);}
		catch(Exception e){}
	}
	
	public void buscarProjetos(){
		try{
		List<Projeto> busca = fachada.buscarProjetos(organizacao, nomeProjeto, responsavel);
		organizacao.setProjetos(busca);}
		catch(Exception e){}
	}
	public void resetarProjetos(){
		try{
			setNomeProjeto("");
			setResponsavel("");
		List<Projeto> busca = fachada.buscarProjetos(organizacao, nomeProjeto, responsavel);
		organizacao.setProjetos(busca);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/listarProjeto.xhtml");}
		catch(Exception e){}
	}
	
	
}
