package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Compileur;
import model.Fidele;
import model.GrandDev;
import model.Indenteur;
import model.Tapoteur;

public class DAOTapoteur implements IDAOTapoteur {
	
	@Override
	public Tapoteur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Tapoteur tapoteur = em.find(Tapoteur.class,id);
		em.close();
		return tapoteur;
	}

	@Override
	public List<Tapoteur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Tapoteur> tapoteurs = em.createQuery("from Tapoteur").getResultList();
		em.close();
		return tapoteurs;
	}

	@Override
	public Tapoteur save(Tapoteur tapoteur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		tapoteur = em.merge(tapoteur);
		em.getTransaction().commit();
		em.close();
		return tapoteur;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Tapoteur tapoteur = em.find(Tapoteur.class,id);
		em.getTransaction().begin();
		em.remove(tapoteur);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Fidele> findAllFidele() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Fidele> fidele = em.createQuery("from Fidele").getResultList();
		em.close();
		return fidele;
	}

	@Override
	public List<Indenteur> findAllIndenteur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Indenteur> indenteur = em.createQuery("from Indenteur").getResultList();
		em.close();
		return indenteur;
	}

	@Override
	public List<Compileur> findAllCompileur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Compileur> compileur = em.createQuery("from Compileur").getResultList();
		em.close();
		return compileur;
	}

	@Override
	public List<GrandDev> findAllGrandDev() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<GrandDev> grandDev = em.createQuery("from GrandDev").getResultList();
		em.close();
		return grandDev;
	}

	@Override
	public Tapoteur findByLoginAndPassword(String login, String password) {
		Tapoteur connected = null;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		try 
		{
			Query q = em.createQuery("from Tapoteur t where t.login=:login and t.password=:password");
			q.setParameter("login", login);
			q.setParameter("password", password);
			connected = (Tapoteur) q.getSingleResult();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return connected;
	}
	

	


}
