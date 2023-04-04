package c.culte.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Evenement;

public interface IDAOEvenement extends JpaRepository<Evenement, Integer>{

	@Query("select e from Evenement e join e.inscrits i where i.id = ?1")
	public List<Evenement> findAllByInscritsId (int tapoteurId);
	
	@Query("select e from Evenement e left join fetch e.inscrits where e.id = ?1")
	public Optional<Evenement> findByIdWithInscrits(int eventId);
	
	@Query("select e from Evenement e left join fetch e.inscrits i")
	public List<Evenement> findAllWithInscrits ();
}
