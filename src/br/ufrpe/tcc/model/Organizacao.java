package br.ufrpe.tcc.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Organizacao")
public class Organizacao {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	
	@Column(name="senha", length=10, nullable=false)
	private String senha;
	
	@OneToMany(mappedBy="organizacao")
	private List<Projeto> projetos;
	
	public Organizacao() {
		
	}
	
	public Organizacao(int id, String nome, 
			String senha){
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	
	public Organizacao(String nome, String senha){
		this.nome = nome;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
}
