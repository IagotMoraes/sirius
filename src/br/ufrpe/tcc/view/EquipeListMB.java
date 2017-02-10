package br.ufrpe.tcc.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Equipe;

@ManagedBean
public class EquipeListMB {
	
	private List<Equipe> listaEquipe;
	private Fachada fachada;
	
	@PostConstruct
	private void init(){
		setListaEquipe(listarEquipe());
	}
	
	private List<Equipe> listarEquipe(){
		return getFachada().listarEquipe();
	}
	
	public void excluir(Equipe equipe){
		getFachada().excluirEquipe(equipe);
		setListaEquipe(listarEquipe());
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}

	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}
	
}
