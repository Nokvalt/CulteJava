package c.culte.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BannisResponse {
	private Integer id;
	private String nom;
	private String prenom;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateBannissement;
	private String motif;
	private String infoBanquaires;
	private Integer tapoteurId;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateBannissement() {
		return dateBannissement;
	}
	public void setDateBannissement(LocalDate dateBannissement) {
		this.dateBannissement = dateBannissement;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getInfoBanquaires() {
		return infoBanquaires;
	}
	public void setInfoBanquaires(String infoBanquaires) {
		this.infoBanquaires = infoBanquaires;
	}
	public Integer getTapoteurId() {
		return tapoteurId;
	}
	public void setTapoteurId(Integer tapoteurId) {
		this.tapoteurId = tapoteurId;
	}
	
}
