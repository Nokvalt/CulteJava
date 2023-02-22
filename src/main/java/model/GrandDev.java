package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("R4")
public class GrandDev extends Tapoteur {
	
	@Column(length=10)
	private String colPull;
	
	@OneToOne
	private Culte culte;
	
	
	public GrandDev() {}

	public GrandDev(String nom, String prenom, Adresse adresse, 
					LocalDate dateAdhesion, String login, String password, String colPull) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
		this.colPull= colPull;
		
	}

	public String getColPull() {
		return colPull;
	}

	public void setColPull(String colPull) {
		this.colPull = colPull;
	}

}
