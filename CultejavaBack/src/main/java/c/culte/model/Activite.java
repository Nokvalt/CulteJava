package c.culte.model;
public enum Activite {
	 
feteCreation("23 Mai"), naissanceProphete("19 Mai"), fetePopups("7 Avril"), 
rassemblement, pelerinnage, promotion, banissement;
	
	private String date;

	private Activite(String date) {
		this.date = date;
	}

	private Activite() {
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
