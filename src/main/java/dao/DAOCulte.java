package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Culte;

public class DAOCulte implements IDAOCulte{

	@Override
	public Culte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Culte culte = em.find(Culte.class,id);
		em.close();
		return culte;
	}

	@Override
	public List<Culte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Culte> culte = em.createQuery("from Culte").getResultList();
		em.close();
		return culte;
	}

	@Override
	public Culte save(Culte culte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		culte = em.merge(culte);
		em.getTransaction().commit();
		em.close();
		return culte;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Culte culte = em.find(Culte.class,id);
		em.getTransaction().begin();
		em.remove(culte);
		em.getTransaction().commit();
		em.close();	
	}

}
