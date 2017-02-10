package br.ufrpe.tcc.view;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.ufrpe.tcc.fachada.Fachada;
import br.ufrpe.tcc.model.Projeto;

@ManagedBean
@SessionScoped
public class ProjetoListMB {
	
	private List<Projeto> listaProjeto;
	private Fachada fachada;
	
	@PostConstruct
	public void init(){
		fachada = new Fachada();
		setListaProjeto(listarProjeto());
	}
	
	private List<Projeto> listarProjeto(){
		return getFachada().listarProjeto();
	}
	
	public void excluir(Projeto projeto) {
		try{
		getFachada().excluirProjeto(projeto);
		init();}
		catch (Exception e){
			
		}
	}

	public List<Projeto> getListaProjeto() {
		return listaProjeto;
	}

	public void setListaProjeto(List<Projeto> listaProjeto) {
		this.listaProjeto = listaProjeto;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
}
