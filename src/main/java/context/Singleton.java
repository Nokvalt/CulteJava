package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOActivite;
import dao.DAOActivite;
import dao.IDAOCulte;
import dao.DAOCulte;
import dao.IDAODemande;
import dao.DAODemande;
import dao.IDAOTapoteur;
import dao.DAOTapoteur;


public class Singleton {
	
	private IDAOActivite daoActivite = new DAOActivite();
	private IDAOCulte daoCulte = new DAOCulte();
	private IDAODemande daoDemande = new DAODemande();
	private IDAOTapoteur daoTapoteur = new DAOTapoteur();
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("cultejava");
	
	private static Singleton instance=null;
	
	private Singleton() {}
	

	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}


	public IDAOActivite getDaoActivite() {
		return daoActivite;
	}


	public void setDaoActivite(IDAOActivite daoActivite) {
		this.daoActivite = daoActivite;
	}


	public IDAOCulte getDaoCulte() {
		return daoCulte;
	}


	public void setDaoCulte(IDAOCulte daoCulte) {
		this.daoCulte = daoCulte;
	}


	public IDAODemande getDaoDemande() {
		return daoDemande;
	}


	public void setDaoDemande(IDAODemande daoDemande) {
		this.daoDemande = daoDemande;
	}


	public IDAOTapoteur getDaoTapoteur() {
		return daoTapoteur;
	}


	public void setDaoTapoteur(IDAOTapoteur daoTapoteur) {
		this.daoTapoteur = daoTapoteur;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	
}

