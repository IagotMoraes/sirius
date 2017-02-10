package br.ufrpe.tcc.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Equipe;

@ManagedBean
public class EquipeEditMB {
	
	private Equipe equipe;
	
	private Fachada fachada;
	
	public boolean isFluxoAlterar(){
		return equipe.getId() !=0;
	}
	
	@PostConstruct
	private void init(){
		equipe = new Equipe();
	}
	
	public void preAlterar(Equipe equipe){
		setEquipe(equipe);
	}
	
	public String salvar(){
		if(isFluxoAlterar()){
			getFachada().alterarEquipe(equipe);
		}
		else{
			getFachada().inserirEquipe(equipe);
		}
		return "success";
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
}
