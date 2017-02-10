package br.ufrpe.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Equipe")
public class Equipe {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="tamanho", length=25, nullable= false)
	private String tamanho;
	@Column(name="experiencia", length=25, nullable= false)
	private String experiencia;
	@Column(name="distribuicao", length=25, nullable= true)
	private String distribuicao;
	@Column(name="eficaciaPOrg", length=25, nullable= true)
	private String eficaciaPOrg;
	@Column(name="focoEquipe", length=25, nullable= true)
	private String focoEquipe;
	@Column(name="conflitoEquipe", length=25, nullable= true)
	private String conflitoEquipe;
	
	public Equipe() {
	}
	
	public Equipe(int id, String tamanho, String experiencia,
			String distribuicao, String eficaciaPOrg, 
			String focoEquipe, 
			String conflitoEquipe){
		this.id = id;
		this.tamanho = tamanho;
		this.experiencia = experiencia;
		this.distribuicao = distribuicao;
		this.eficaciaPOrg = eficaciaPOrg;
		this.focoEquipe = focoEquipe;
		this.conflitoEquipe = conflitoEquipe;
	}
	
	public Equipe(String tamanho, String experiencia,
			String distribuicao, String eficaciaPOrg, 
			String focoEquipe, 
			String conflitoEquipe){
		this.tamanho = tamanho;
		this.experiencia = experiencia;
		this.distribuicao = distribuicao;
		this.eficaciaPOrg = eficaciaPOrg;
		this.focoEquipe = focoEquipe;
		this.conflitoEquipe = conflitoEquipe;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	public String getDistribuicao() {
		return distribuicao;
	}
	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}
	public String getEficaciaPOrg() {
		return eficaciaPOrg;
	}
	public void setEficaciaPOrg(String eficaciaPOrg) {
		this.eficaciaPOrg = eficaciaPOrg;
	}
	public String getFocoEquipe() {
		return focoEquipe;
	}
	public void setFocoEquipe(String focoEquipe) {
		this.focoEquipe = focoEquipe;
	}
	public String getConflitoEquipe() {
		return conflitoEquipe;
	}
	public void setConflitoEquipe(String conflitoEquipe) {
		this.conflitoEquipe = conflitoEquipe;
	}
}
