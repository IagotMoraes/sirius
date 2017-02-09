package br.ufrpe.tcc.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufrpe.tcc.model.Equipe;

public class EquipeDAO {
	
	public EquipeDAO() {
		
	}
	
	public void excluir(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Equipe equipe = em.find(Equipe.class, id);
		em.remove(equipe);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipe> listarEquipe(){
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select e from Equipe e");
		
		return query.getResultList();
	}
	
	public void inserir (Equipe equipe){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(equipe);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Equipe buscar(int idEquipe){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		
		return em.find(Equipe.class, idEquipe);
	}
	
	public void alterar(Equipe equipe){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(equipe);
		em.getTransaction().commit();
		
		em.close();
	}
}
