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
	private IDAOCulte daoBiome = new DAOCulte();
	private IDAODemande daoCompte = new DAODemande();
	private IDAOTapoteur daoEspece = new DAOTapoteur();
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


	public IDAOCulte getDaoBiome() {
		return daoBiome;
	}


	public void setDaoBiome(IDAOCulte daoBiome) {
		this.daoBiome = daoBiome;
	}


	public IDAODemande getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAODemande daoCompte) {
		this.daoCompte = daoCompte;
	}


	public IDAOTapoteur getDaoEspece() {
		return daoEspece;
	}


	public void setDaoEspece(IDAOTapoteur daoEspece) {
		this.daoEspece = daoEspece;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	
}

