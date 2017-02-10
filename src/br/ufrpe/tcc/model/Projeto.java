package br.ufrpe.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Projeto")
public class Projeto {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="nome", length=250, nullable= true)
	private String nome;
	@Column(name="responsavel", length=100)
	private String responsavel;
	@Column(name="tamanhoProj", length=150)
	private String tamanhoProj;
	@Column(name="complexidadeProj", length=150)
	private String complexidadeProj;
	@Column(name="NivelReuso", length=50)
	private String nivelReuso;
	@Column(name="nivelInterface", length=50)
	private String nivelInterface;
	@Column (name="distribuicaoGeografica", length=50)
	private String distribuicaoGeografica;
	@Column (name="nivelConflito", length=50)
	private String nivelConflito;
	@Column (name="disponibilidadeRecursos", length=50)
	private String disponibilidadeRecursos;
	@Column (name="dependenciaExterna", length=50)
	private String dependenciaExterna;
	@Column (name="EstabilidadeRequisitos", length=50)
	private String estabilidadeRequisitos;
	@Column (name="ComplexidadeRequisitos", length=50)
	private String complexidadeRequisitos;
	@Column(name="AvaliacaoGestao", nullable=true)
	private double avaliacaoGestao;
	@Column(name="AvaliacaoCultural", nullable=true)
	private double avaliacaoCultural;
	@Column(name="AvaliacaoEconomico", nullable=true)
	private double avaliacaoEconomico;
	@Column(name="AvaliacaoRequisito", nullable=true)
	private double avaliacaoRequisito;
	@Column(name="AvaliacaoAplicacao", nullable=true)
	private double avaliacaoAplicacao;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Organizacao organizacao;
	
	
	public Projeto() {
		
	}
	
	public Projeto(int id, String nome, String responsavel,
			String tamanhoProj, String complexidadeProj,
			String nivelReuso, String nivelInterface,
			String distribuicaoGeografica, String nivelConflito, 
			String disponibilidadeRecursos, String dependenciaExterna, 
			String estabilidadeRequisitos, String complexidadeRequisitos){
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.tamanhoProj = tamanhoProj;
		this.complexidadeProj = complexidadeProj;
		this.nivelReuso = nivelReuso;
		this.nivelInterface = nivelInterface;
		this.distribuicaoGeografica = distribuicaoGeografica;
		this.nivelConflito = nivelConflito;
		this.disponibilidadeRecursos = disponibilidadeRecursos;
		this.dependenciaExterna = dependenciaExterna;
		this.estabilidadeRequisitos = estabilidadeRequisitos;
		this.complexidadeRequisitos = complexidadeRequisitos;
	}
	
	public Projeto(String nome, String responsavel,
			String tamanhoProj, String complexidadeProj,
			String nivelReuso, String nivelInterface,
			String distribuicaoGeografica, String nivelConflito, 
			String disponibilidadeRecursos, String dependenciaExterna, 
			String estabilidadeRequisitos, String complexidadeRequisitos){
		this.nome = nome;
		this.responsavel = responsavel;
		this.tamanhoProj = tamanhoProj;
		this.complexidadeProj = complexidadeProj;
		this.nivelReuso = nivelReuso;
		this.nivelInterface = nivelInterface;
		this.distribuicaoGeografica = distribuicaoGeografica;
		this.nivelConflito = nivelConflito;
		this.disponibilidadeRecursos = disponibilidadeRecursos;
		this.dependenciaExterna = dependenciaExterna;
		this.estabilidadeRequisitos = estabilidadeRequisitos;
		this.complexidadeRequisitos = complexidadeRequisitos;
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
	
	public String getNivelReuso() {
		return nivelReuso;
	}

	public void setNivelReuso(String nivelReuso) {
		this.nivelReuso = nivelReuso;
	}

	public String getNivelInterface() {
		return nivelInterface;
	}

	public void setNivelInterface(String nivelInterface) {
		this.nivelInterface = nivelInterface;
	}

	public String getDistribuicaoGeografica() {
		return distribuicaoGeografica;
	}

	public void setDistribuicaoGeografica(String distribuicaoGeografica) {
		this.distribuicaoGeografica = distribuicaoGeografica;
	}

	public String getNivelConflito() {
		return nivelConflito;
	}

	public void setNivelConflito(String nivelConflito) {
		this.nivelConflito = nivelConflito;
	}

	public String getDisponibilidadeRecursos() {
		return disponibilidadeRecursos;
	}

	public void setDisponibilidadeRecursos(String disponibilidadeRecursos) {
		this.disponibilidadeRecursos = disponibilidadeRecursos;
	}

	public String getDependenciaExterna() {
		return dependenciaExterna;
	}

	public void setDependenciaExterna(String dependenciaExterna) {
		this.dependenciaExterna = dependenciaExterna;
	}

	public String getEstabilidadeRequisitos() {
		return estabilidadeRequisitos;
	}

	public void setEstabilidadeRequisitos(String estabilidadeRequisitos) {
		this.estabilidadeRequisitos = estabilidadeRequisitos;
	}

	public String getComplexidadeRequisitos() {
		return complexidadeRequisitos;
	}

	public void setComplexidadeRequisitos(String complexidadeRequisitos) {
		this.complexidadeRequisitos = complexidadeRequisitos;
	}

	public double getAvaliacaoGestao() {
		return avaliacaoGestao;
	}

	public void setAvaliacaoGestao(double avaliacao) {
		this.avaliacaoGestao = avaliacao;
	}
	
	public double getAvaliacaoCultural() {
		return avaliacaoCultural;
	}

	public void setAvaliacaoCultural(double avaliacao) {
		this.avaliacaoCultural = avaliacao;
	}
	
	public double getAvaliacaoEconomico() {
		return avaliacaoEconomico;
	}

	public void setAvaliacaoEconomico(double avaliacao) {
		this.avaliacaoEconomico = avaliacao;
	}
	
	public double getAvaliacaoRequisito() {
		return avaliacaoRequisito;
	}

	public void setAvaliacaoRequisito(double avaliacao) {
		this.avaliacaoRequisito = avaliacao;
	}
	
	public double getAvaliacaoAplicacao() {
		return avaliacaoAplicacao;
	}

	public void setAvaliacaoAplicacao(double avaliacao) {
		this.avaliacaoAplicacao = avaliacao;
	}

	public Organizacao getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}
	
}

