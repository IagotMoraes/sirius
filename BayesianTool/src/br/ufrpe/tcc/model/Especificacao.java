package br.ufrpe.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Criar get e set pra usuario

@Entity
@Table(name="Especificacao")
public class Especificacao {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="ClarezaReq", length=25, nullable= true)
	private String clarezaReq;
	@Column(name="EstabilidadeReq", length=25, nullable= true)
	private String estabilidadeReq;
	@Column(name="ComplexidadeReq", length=25, nullable= true)
	private String complexidadeReq;
	@Column(name="EspecificacaoTeste", length=25, nullable= true)
	private String especificacaoTeste;
	@Column(name="FrequenciaMudanca", length=25, nullable= true)
	private String frequenciaMudanca;
	@Column(name="dependeciaExterna", length=25, nullable= true)
	private String dependenciaExterna;
	@Column(name="ConformidadeQualidade", length=25, nullable= true)
	private String conformidadeQualidade;
	@Column(name="ImpactoMudanca", length=25, nullable= true)
	private String impactoMudanca;
	@Column(name="ReusoComponentes", length=25, nullable= true)
	private String reusoComponentes;
	@Column(name="Usabilidade", length=25, nullable= true)
	private String usabilidade;
	@Column(name="DisponibilidaeRecursos", length=25, nullable= true)
	private String disponibilidadeRecursos;
	
	public Especificacao() {
		
	}
	
	public Especificacao(int id, String clarezaReq, 
			String estabilidadeReq, String complexidadeReq,
			String especificacaoTeste, String frequenciaMudanca,
			String dependenciaExterna, String conformidadeQualidade,
			String impactoMudanca, String reusoComponentes, 
			String usabilidade, String disponibilidadeRecursos){
		this.id = id;
		this.clarezaReq = clarezaReq;
		this.estabilidadeReq = estabilidadeReq;
		this.complexidadeReq = complexidadeReq;
		this.especificacaoTeste = especificacaoTeste;
		this.frequenciaMudanca = frequenciaMudanca;
		this.dependenciaExterna = dependenciaExterna;
		this.conformidadeQualidade = conformidadeQualidade;
		this.impactoMudanca = impactoMudanca;
		this.reusoComponentes = reusoComponentes;
		this.usabilidade = usabilidade;
		this.disponibilidadeRecursos = disponibilidadeRecursos;
	}
	
	public Especificacao(String clarezaReq, 
			String estabilidadeReq, String complexidadeReq,
			String especificacaoTeste, String frequenciaMudanca,
			String dependenciaExterna, String conformidadeQualidade,
			String impactoMudanca, String reusoComponentes, 
			String usabilidade, String disponibilidadeRecursos){
		this.clarezaReq = clarezaReq;
		this.estabilidadeReq = estabilidadeReq;
		this.complexidadeReq = complexidadeReq;
		this.especificacaoTeste = especificacaoTeste;
		this.frequenciaMudanca = frequenciaMudanca;
		this.dependenciaExterna = dependenciaExterna;
		this.conformidadeQualidade = conformidadeQualidade;
		this.impactoMudanca = impactoMudanca;
		this.reusoComponentes = reusoComponentes;
		this.usabilidade = usabilidade;
		this.disponibilidadeRecursos = disponibilidadeRecursos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClarezaReq() {
		return clarezaReq;
	}
	public void setClarezaReq(String clarezaReq) {
		this.clarezaReq = clarezaReq;
	}
	public String getEstabilidadeReq() {
		return estabilidadeReq;
	}
	public void setEstabilidadeReq(String estabilidadeReq) {
		this.estabilidadeReq = estabilidadeReq;
	}
	public String getComplexidadeReq() {
		return complexidadeReq;
	}
	public void setComplexidadeReq(String complexidadeReq) {
		this.complexidadeReq = complexidadeReq;
	}
	public String getEspecificacaoTeste() {
		return especificacaoTeste;
	}
	public void setEspecificacaoTeste(String especificacaoTeste) {
		this.especificacaoTeste = especificacaoTeste;
	}
	public String getFrequenciaMudanca() {
		return frequenciaMudanca;
	}
	public void setFrequenciaMudanca(String frequenciaMudanca) {
		this.frequenciaMudanca = frequenciaMudanca;
	}
	public String getDependenciaExterna() {
		return dependenciaExterna;
	}
	public void setDependenciaExterna(String dependenciaExterna) {
		this.dependenciaExterna = dependenciaExterna;
	}
	public String getConformidadeQualidade() {
		return conformidadeQualidade;
	}
	public void setConformidadeQualidade(String conformidadeQualidade) {
		this.conformidadeQualidade = conformidadeQualidade;
	}
	public String getImpactoMudanca() {
		return impactoMudanca;
	}
	public void setImpactoMudanca(String impactoMudanca) {
		this.impactoMudanca = impactoMudanca;
	}
	public String getReusoComponentes() {
		return reusoComponentes;
	}
	public void setReusoComponentes(String reusoComponentes) {
		this.reusoComponentes = reusoComponentes;
	}
	public String getUsabilidade() {
		return usabilidade;
	}
	public void setUsabilidade(String usabilidade) {
		this.usabilidade = usabilidade;
	}
	public String getDisponibilidadeRecursos() {
		return disponibilidadeRecursos;
	}
	public void setDisponibilidadeRecursos(String disponibilidadeRecursos) {
		this.disponibilidadeRecursos = disponibilidadeRecursos;
	}
}
