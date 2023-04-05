package c.culte.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("grandDev")
public class GrandDev extends Tapoteur {
	
	@JsonView(Views.GrandDev.class)
	@Column(length=10)
	private String colPull;
	
	@Column(nullable = false)
	private Double allDons;
	@Column(nullable = false)
	private Double argentVole;
	
	
	
	
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

	public Double getAllDons() {
		return allDons;
	}

	public void setAllDons(Double sommeDons) {
		this.allDons = sommeDons;
	}

	public Double getArgentVole() {
		return argentVole;
	}

	public void setArgentVole(Double argentVole) {
		this.argentVole = argentVole;
	}
	
	

}
