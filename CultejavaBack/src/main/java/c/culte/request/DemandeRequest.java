package c.culte.request;

import c.culte.model.Statut;

public class DemandeRequest {
		private String descriptif;
		private Integer indenteurid; 
		private double montant;
		private Statut statut = Statut.enAttente;
		
		public Statut getStatut() {
			return statut;
		}
		public void setStatut(Statut statut) {
			this.statut = statut;
		}
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



		// TODO indenteur Id
		

		
}
