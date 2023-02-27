package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	
	@Column(nullable=false)
	private double argent;
	@Column(nullable=false)
	private int effectif;
	@OneToMany(mappedBy="culte")
	private List <Evenement> listEvenement = new ArrayList();
	@OneToMany(mappedBy="culte")
	private List <Tapoteur> listTapoteur = new ArrayList();
	@OneToOne(mappedBy="culte")
	private GrandDev Dave;
	
	public Culte(double argent, int effectif,
			GrandDev dave) {
		super();
		this.argent = argent;
		this.effectif = effectif;
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
