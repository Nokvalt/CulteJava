package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R3")
public class Compileur extends Tapoteur {
	
	public Compileur() {}

	public Compileur(String nom, String prenom, String adresse, String dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}

}
