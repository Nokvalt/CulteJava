package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Evenement;

public class DAOEvenement implements IDAOEvenement {

	@Override
	public Evenement findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Evenement evenement = em.find(Evenement.class,id);
		em.close();
		return evenement;
	}

	@Override
	public List<Evenement> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Evenement> evenements = em.createQuery("from Evenement").getResultList();
		em.close();
		return evenements;
	}

	@Override
	public Evenement save(Evenement evenement) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		evenement = em.merge(evenement);
		em.getTransaction().commit();
		em.close();
		return evenement;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Evenement evenement = em.find(Evenement.class,id);
		em.getTransaction().begin();
		em.remove(evenement);
		em.getTransaction().commit();
		em.close();	
		
	}
	
}
