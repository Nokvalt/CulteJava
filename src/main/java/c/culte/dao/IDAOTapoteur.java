package c.culte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Compileur;
import c.culte.model.Fidele;
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
	public List<Compileur> findAllGrandDev();
	
	
}
