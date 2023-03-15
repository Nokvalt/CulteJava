package c.culte.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class BannissementRequest {
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateBannissement;
	private String motif;
	private String infoBanquaires;
	
	
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
	
	
}
