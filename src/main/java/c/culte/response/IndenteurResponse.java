package c.culte.response;

public class IndenteurResponse extends TapoteurResponse{
	
	private Integer demandeId;
	private double demandeMontant;
	private String demandeStatut;
	
	
	public Integer getDemandeId() {
		return demandeId;
	}
	public void setDemandeId(Integer demandeId) {
		this.demandeId = demandeId;
	}
	public double getDemandeMontant() {
		return demandeMontant;
	}
	public void setDemandeMontant(double demandeMontant) {
		this.demandeMontant = demandeMontant;
	}
	public String getDemandeStatut() {
		return demandeStatut;
	}
	public void setDemandeStatut(String demandeStatut) {
		this.demandeStatut = demandeStatut;
	}
	
	
	
}
