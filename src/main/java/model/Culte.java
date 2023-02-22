package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Culte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private double argent;
	private int effectif;
	@OneToMany
	private List <Evenement> listEvenement = new ArrayList();
	@ManyToMany
	private List <Tapoteur> listTapoteur = new ArrayList();
	@OneToOne
	private GrandDev Dave;
	
	public Culte(double argent, int effectif, List<Evenement> listEvenement, List<Tapoteur> listTapoteur,
			GrandDev dave) {
		super();
		this.argent = argent;
		this.effectif = effectif;
		this.listEvenement = listEvenement;
		this.listTapoteur = listTapoteur;
		Dave = dave;
	}
public Culte() {}

	public double getArgent() {
		return argent;
	}

	public void setArgent(double argent) {
		this.argent = argent;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public List<Evenement> getListEvenement() {
		return listEvenement;
	}

	public void setListEvenement(List<Evenement> listEvenement) {
		this.listEvenement = listEvenement;
	}

	public List<Tapoteur> getListTapoteur() {
		return listTapoteur;
	}

	public void setListTapoteur(List<Tapoteur> listTapoteur) {
		this.listTapoteur = listTapoteur;
	}

	public GrandDev getDave() {
		return Dave;
	}

	public void setDave(GrandDev dave) {
		Dave = dave;
	}
	
	
	
	
}
