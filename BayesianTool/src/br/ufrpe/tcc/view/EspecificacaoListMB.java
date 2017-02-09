package br.ufrpe.tcc.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Especificacao;

@ManagedBean
public class EspecificacaoListMB {
	
	private List<Especificacao> listaEspecificacao;
	private Fachada fachada;
	
	@PostConstruct
	public void init(){
		setListaEspecificacao(listarEspecificacao());
	}
	
	private List<Especificacao> listarEspecificacao(){
		return getFachada().listarEspecificacao();
	}
	
	public void excluir(Especificacao especificacao){
		getFachada().excluirEspecificacao(especificacao);
		setListaEspecificacao(listarEspecificacao());
	}
	
	public List<Especificacao> getListaEspecificacao() {
		return listaEspecificacao;
	}
	public void setListaEspecificacao(List<Especificacao> listaEspecificacao) {
		this.listaEspecificacao = listaEspecificacao;
	}
	public Fachada getFachada() {
		return fachada;
	}
	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
}
