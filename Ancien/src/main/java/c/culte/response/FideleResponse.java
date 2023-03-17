package c.culte.response;

import java.util.List;

import c.culte.model.Evenement;

public class FideleResponse extends TapoteurResponse{

	@Override
	public String getRang() {
		return "Fidele";
	}
	
	/*private List<EvenementResponse> inscriptions;

	public List<EvenementResponse> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<EvenementResponse> inscriptions) {
		this.inscriptions = inscriptions;
	}*/
}
