package br.ufrpe.tcc.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Organizacao;

@ManagedBean
public class OrganizacaoListMB {
	
	private List<Organizacao> listaOrganizacao;
	private Fachada fachada;
	
	@PostConstruct
	public void init(){
		fachada = new Fachada();
		setListaOrganizacao(listarOrganizacao());
	}
	
	private List<Organizacao> listarOrganizacao(){
		return getFachada().listarOrganizacao();
	}
	
	public void excluir(Organizacao organizacao){
		getFachada().excluirOrganizacao(organizacao);
		setListaOrganizacao(listarOrganizacao());
	}

	public List<Organizacao> getListaOrganizacao() {
		return listaOrganizacao;
	}

	public void setListaOrganizacao(List<Organizacao> listaOrganizacao) {
		this.listaOrganizacao = listaOrganizacao;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	

}
