package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fidele")
public class Fidele extends Tapoteur {

	public Fidele() {}
	
	public Fidele(String nom, String prenom, Adresse adresse, LocalDate dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}

}
