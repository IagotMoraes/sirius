package br.ufrpe.tcc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//Arruma os gete e set de especificacao e equipe

//@Entity
@Table(name = "Projeto")
public class ProjetoFuturo {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="nome", length=250, nullable= true)
	private String nome;
	@Column(name="responsavel", length=100, nullable=false)
	private String responsavel;
	@Column(name="tamanhoProj", length=150, nullable=false)
	private String tamanhoProj;
	@Column(name="complexidadeProj", length=150, nullable=false)
	private String complexidadeProj;
	@Column(name="criticalidadeProj", length=150, nullable=false)
	private String criticalidadeProj;
	@Column(name="experienciaGerente", length=100, nullable=false)
	private String experienciaGerente;
	@Column(name="Avaliacao", nullable=true)
	private String avaliacao;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Especificacao especificacao;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Equipe equipe;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Organizacao organizacao;
	
	
	public ProjetoFuturo() {
		
	}
	
	public ProjetoFuturo(int id, String nome, String responsavel,
			String tamanhoProj, String complexidadeProj,
			String criticalidadeProj, String experienciaGerente,
			Especificacao especificacao, Equipe equipe){
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.tamanhoProj = tamanhoProj;
		this.complexidadeProj = complexidadeProj;
		this.criticalidadeProj = criticalidadeProj;
		this.experienciaGerente = experienciaGerente;
		this.especificacao = especificacao;
		this.equipe = equipe;
	}
	
	public ProjetoFuturo(String nome,  String responsavel,
			String tamanhoProj, String complexidadeProj,
			String criticalidadeProj, String experienciaGerente,
			Especificacao especificacao, Equipe equipe){
		this.nome = nome;
		this.responsavel = responsavel;
		this.tamanhoProj = tamanhoProj;
		this.complexidadeProj = complexidadeProj;
		this.criticalidadeProj = criticalidadeProj;
		this.experienciaGerente = experienciaGerente;
		this.especificacao = especificacao;
		this.equipe = equipe;
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
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTamanhoProj() {
		return tamanhoProj;
	}
	public void setTamanhoProj(String tamanhoProj) {
		this.tamanhoProj = tamanhoProj;
	}
	public String getComplexidadeProj() {
		return complexidadeProj;
	}
	public void setComplexidadeProj(String complexidadeProj) {
		this.complexidadeProj = complexidadeProj;
	}
	public String getCriticalidadeProj() {
		return criticalidadeProj;
	}
	public void setCriticalidadeProj(String criticalidadeProj) {
		this.criticalidadeProj = criticalidadeProj;
	}
	public String getExperienciaGerente() {
		return experienciaGerente;
	}
	public void setExperienciaGerente(String experienciaGerente) {
		this.experienciaGerente = experienciaGerente;
	}
	public Especificacao getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Organizacao getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}
	
}
