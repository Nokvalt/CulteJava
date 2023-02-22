package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("indenteur")
public class Indenteur extends Tapoteur {
	
	@OneToOne(mappedBy="indenteur")
	private Demande statutDemande;

	public Indenteur() {}

	public Indenteur(String nom, String prenom, Adresse adresse, LocalDate dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}
	
	public Demande getStatutDemande() {
		return statutDemande;
	}

	public void setStatutDemande(Demande statutDemande) {
		this.statutDemande = statutDemande;
	}
	

}
