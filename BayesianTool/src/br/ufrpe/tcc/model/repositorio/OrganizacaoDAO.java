package br.ufrpe.tcc.model.repositorio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufrpe.tcc.model.Organizacao;

public class OrganizacaoDAO {

	public OrganizacaoDAO() {
		
	}
	
	public void excluirOrganizacao(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Organizacao organizacao = em.find(Organizacao.class, id);
		em.remove(organizacao);
		em.getTransaction().commit();
		em.close();
	}
	
	public Organizacao buscarOrganizacao(int id){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		return em.find(Organizacao.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Organizacao> listarOrganizacao(){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select o from Organizacao o");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Organizacao buscarOrganizacao(String nome, String senha){
		try{
			EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("select o from Organizacao o "
				+"where o.nome = :nome and o.senha = :senha");
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		return (Organizacao) query.getSingleResult();
		}
		catch(javax.persistence.NoResultException e){
			return null;
		}
		
	}
	
	public void inserir(Organizacao organizacao){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(organizacao);
		em.getTransaction().commit();
		em.close();
	}
	
	public void alterar(Organizacao organizacao){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BayesianTool");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(organizacao);
		em.getTransaction().commit();
		em.close();
	}
}
