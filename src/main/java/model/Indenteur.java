package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("R2")
public class Indenteur extends Tapoteur {
	
	@OneToOne(mappedBy="statut")
	private Demande statutDemande;

	

	public Indenteur(String nom, String prenom, String adresse, String dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}
	
	public Demande getStatutDemande() {
		return statutDemande;
	}

	public void setStatutDemande(Demande statutDemande) {
		this.statutDemande = statutDemande;
	}
	

}
