package br.ufrpe.tcc.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Especificacao;

@ManagedBean
public class EspecificacaoEditMB {
	
	private Especificacao especificacao;
	private Fachada fachada;
	
	public boolean isFluxoAlterar(){
		return especificacao.getId() != 0;
	}
	
	@PostConstruct
	private void init(){
		especificacao = new Especificacao();
	}
	
	public void preAlterar(Especificacao especificacao){
		setEspecificacao(especificacao);
	}
	
	public String salvar(){
		if(isFluxoAlterar()){
			getFachada().alterarEspecificacao(especificacao);
		}
		else{
			getFachada().inserirEspecificacao(especificacao);
		}
		return "success";
	}
	public Especificacao getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}
	public Fachada getFachada() {
		return fachada;
	}
	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	
}
