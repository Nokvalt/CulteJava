package c.culte.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Compileur;
import c.culte.model.Evenement;
import c.culte.model.Fidele;
import c.culte.model.GrandDev;
import c.culte.model.Indenteur;
import c.culte.model.Tapoteur;

public interface IDAOTapoteur extends JpaRepository<Tapoteur,Integer> {
	@Query("SELECT f FROM Fidele f")
	public List<Fidele> findAllFidele();
	
	@Query("SELECT i FROM Indenteur i")
	public List<Indenteur> findAllIndenteur();
	
	@Query("SELECT c FROM Compileur c")
	public List<Compileur> findAllCompileur();
	
	@Query("SELECT d FROM GrandDev d")
	public List<GrandDev> findAllGrandDev();
	
	@Query("select t from Tapoteur t left join fetch t.inscriptions where t.id = ?1")
	public Optional<Tapoteur> findByIdWithInscriptions(int evenementId);
	
	public Optional<Tapoteur> findByLogin(String login);
	
}
