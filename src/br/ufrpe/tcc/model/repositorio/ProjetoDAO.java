package br.ufrpe.tcc.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.ufrpe.tcc.model.Organizacao;
import br.ufrpe.tcc.model.Projeto;

public class ProjetoDAO {
	
	public ProjetoDAO() {
		
	}
	
	public void excluirProjeto(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Projeto projeto = em.find(Projeto.class, id);
		em.remove(projeto);
		em.getTransaction().commit();
		em.close();
	}
	
	public Projeto buscarProjeto(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		return em.find(Projeto.class, id);
	}
	
	protected String stringBusca(String nomeProjeto, String responsavel){
		String busca ="";
		if(nomeProjeto!=""){
			busca+= " and upper(p.nome) like :nomeProjeto";
		}
		if(responsavel!=""){
			busca+= " and upper(p.responsavel) like :responsavel";
		}
		return busca;
	}
	
	protected void setParameters(String nomeProjeto, String responsavel, Query query){
		if(nomeProjeto!=""){
			query.setParameter("nomeProjeto", "%"+ nomeProjeto.toUpperCase()+"%");
		}
		if(responsavel!=""){
			query.setParameter("responsavel", "%"+ responsavel.toUpperCase()+"%");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> buscarProjetos(Organizacao org, String nomeProjeto, String responsavel){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		String busca = "select p from Projeto p where p.organizacao = :org" +stringBusca(nomeProjeto, responsavel);
		Query query = em.createQuery(busca);
		query.setParameter("org", org);
		setParameters(nomeProjeto, responsavel, query);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjeto(){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select p from Projeto p");
		return query.getResultList();
	}
	
	public void inserir(Projeto projeto){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void alterar(Projeto projeto){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(projeto);
		em.getTransaction().commit();
		em.close();
	}
}
