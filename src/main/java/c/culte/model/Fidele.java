package c.culte.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@DiscriminatorValue("fidele")
public class Fidele extends Tapoteur {
	
	@JsonView(Views.Fidele.class)
	@ManyToMany
	@JoinTable(name="inscriptions", joinColumns = @JoinColumn(name = "fideleId"), inverseJoinColumns = @JoinColumn(name = "evenementId"))
	private List<Evenement> inscriptions;
	
	
	public Fidele() {}
	
	public Fidele(String nom, String prenom, Adresse adresse, LocalDate dateAdhesion, String login, String password) {
		super(nom, prenom, adresse, dateAdhesion, login, password);
		
	}

	public List<Evenement> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Evenement> inscriptions) {
		this.inscriptions = inscriptions;
	}
	

}
