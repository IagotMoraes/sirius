package br.ufrpe.tcc.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufrpe.tcc.model.Especificacao;

public class EspecificacaoDAO {
	
	public EspecificacaoDAO(){
		
	}
	
	public void excluir(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Especificacao especificacao = em.find(Especificacao.class, id);
		em.remove(especificacao);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Especificacao> listarEspecificacao(){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select e from Especificacao e");
		return query.getResultList();
	}
	
	public void inserir(Especificacao especificacao){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(especificacao);
		em.getTransaction().commit();
		em.close();
	}
	
	public Especificacao buscar(int IdEspec){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		
		return em.find(Especificacao.class, IdEspec);
	}
	
	public void alterar(Especificacao especificacao){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(especificacao);
		em.getTransaction().commit();
		em.close();
	}
}
