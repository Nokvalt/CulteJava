package c.culte.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



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
	@OneToOne
	private GrandDev Dave;
	
	public Culte(double argent, int effectif,
			GrandDev dave) {
		super();
		this.argent = argent;
		this.effectif = effectif;
		Dave = dave;
	}
	

	
	public Culte(double argent, int effectif) {
		super();
		this.argent = argent;
		this.effectif = effectif;
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
