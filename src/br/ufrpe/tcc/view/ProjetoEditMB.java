package br.ufrpe.tcc.view;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.Projeto;
import br.ufrpe.tcc.util.RedeAplicacao;
import br.ufrpe.tcc.util.RedeCultural;
import br.ufrpe.tcc.util.RedeEconomico;
import br.ufrpe.tcc.util.RedeGestao;
import br.ufrpe.tcc.util.RedeRequisito;

@ManagedBean
@SessionScoped
public class ProjetoEditMB {
	
	private Projeto projeto;
	private Fachada fachada;

	
	public boolean isFluxoAlterar(){
		return projeto.getId() != 0;
	}
	
	@PostConstruct
	private void init(){
		projeto = new Projeto();
		fachada = new Fachada();
		Organizacao org = (Organizacao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Organizacao");
		projeto.setOrganizacao(org);
	}
	
	public void preAlterar(Projeto projeto){
		setProjeto(projeto);
	}
	
	public String salvar(){
		if(isFluxoAlterar()){
			getFachada().alterarProjeto(projeto);
		}
		else{
			
			getFachada().inserirProjeto(projeto);
		}
		return "success";
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	public void org(Organizacao org){
		projeto.setOrganizacao(org);
	}
	public void avaliarGestao(){
		RedeGestao rg = new RedeGestao();
		double avaliacao = rg.avaliarGestao(projeto);
		projeto.setAvaliacaoGestao(avaliacao);
	}
	public void avaliarCultural(){
		RedeCultural rc = new RedeCultural();
		double avaliacao = rc.avaliarcultural(projeto);
		projeto.setAvaliacaoCultural(avaliacao);
	}
	public void avaliarEconomico(){
		RedeEconomico re = new RedeEconomico();
		double avaliacao = re.avaliarEconomico(projeto);
		projeto.setAvaliacaoEconomico(avaliacao);
	}
	public void avaliarRequisito(){
		RedeRequisito rr = new RedeRequisito();
		double avaliacao = rr.avaliarRequisitos(projeto);
		projeto.setAvaliacaoRequisito(avaliacao);
	}
	public void avaliarAplicacao(){
		RedeAplicacao ra = new RedeAplicacao();
		double avaliacao = ra.avaliaraplicacao(projeto);
		projeto.setAvaliacaoAplicacao(avaliacao);
	}
	public void avaliar() throws Exception{
		if(projeto.getOrganizacao()!= null){
		avaliarGestao();
		avaliarCultural();
		avaliarEconomico();
		avaliarRequisito();
		avaliarAplicacao();
		salvar();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/avaliacao.xhtml");
		}
	}
	public void reavaliar() throws Exception{
		FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/inserirProjeto.xhtml");
	}
	public void novoProjeto() throws Exception{
		init();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/inserirProjeto.xhtml");
	}
	public void atualizar(Projeto projeto) throws Exception{
		this.projeto = projeto;
		FacesContext.getCurrentInstance().getExternalContext().redirect("/BayesianTool/inserirProjeto.xhtml");
	}
}
