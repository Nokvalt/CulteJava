package c.culte.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("indenteur")
public class Indenteur extends Tapoteur {
	@JsonView(Views.Indenteur.class)
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
