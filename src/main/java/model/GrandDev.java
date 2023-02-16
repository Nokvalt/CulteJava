package model;

public class GrandDev extends Tapoteur {

	private String colPull;
	
	public GrandDev(String nom, String prenom, String adresse, 
					String dateAdhesion, String login, String password, String colPull) {
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
