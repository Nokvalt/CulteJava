package c.culte.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import c.culte.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dons")
public class Don {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	@JsonView(Views.Don.class)
	private Integer id;
	
	@ManyToOne
	@JsonView(Views.Don.class)
	@JoinColumn(nullable=false)
	private Tapoteur tapoteur;
	
	@Column(name = "montant", nullable=false)
	@JsonView(Views.Don.class)
	private double montant;
	
	@Column(name = "heure", nullable=false)
	@JsonView(Views.Don.class)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateDon;

	public Don(Integer id, Tapoteur tapoteur, double montant, LocalDate dateDon) {
		this.id = id;
		this.tapoteur = tapoteur;
		this.montant = montant;
		this.dateDon = dateDon;
	}
	
	

	



	public Don() {
	}


	public Tapoteur getTapoteur() {
		return tapoteur;
	}



	public void setTapoteur(Tapoteur tapoteur) {
		this.tapoteur = tapoteur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDate getDateDon() {
		return dateDon;
	}

	public void setDateDon(LocalDate dateDon) {
		this.dateDon = dateDon;
	}
	
	

}
