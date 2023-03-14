package c.culte.request;

public class DemandeRequest {

		private String descriptif;
		private Integer indenteurid ; 
		private double montant;
		private String statut = "en-cours";
		
		public String getDescriptif() {
			return descriptif;
		}
		public void setDescriptif(String descriptif) {
			this.descriptif = descriptif;
		}

		public Integer getIndenteurid() {
			return indenteurid;
		}
		public void setIndenteurid(Integer indenteurid) {
			this.indenteurid = indenteurid;
		}
		public double getMontant() {
			return montant;
		}
		public void setMontant(double montant) {
			this.montant = montant;
		}
		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut;
		}


		// TODO indenteur Id
		

		
}
