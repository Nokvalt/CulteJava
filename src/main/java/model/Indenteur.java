package model;

public class Indenteur extends Tapoteur {
	
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
