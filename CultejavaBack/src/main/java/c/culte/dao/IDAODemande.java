package c.culte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Demande;

public interface IDAODemande extends JpaRepository<Demande,Integer> {
	
	@Query("select d from Demande d left join fetch d.indenteur i where i.id = ?1")
	public List<Demande> findAllByIndenteurId(Integer indenteurId);
}