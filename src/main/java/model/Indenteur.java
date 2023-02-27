package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("indenteur")
public class Indenteur extends Tapoteur {
	
	@OneToOne(mappedBy="indenteur")
	private Demande demande;

	public Indenteur() {}

	public Indenteur(String nom, String prenom, Adresse adresse, LocalDate dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}
	
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande statutDemande) {
		this.demande = statutDemande;
	}
	

}
