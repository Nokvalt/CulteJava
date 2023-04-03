package c.culte.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Bannis;
import c.culte.model.Tapoteur;

public interface IDAOBannis extends JpaRepository<Bannis,Integer> {
	
	public Optional<Bannis> findByTapoteurId(Integer id);
	
	@Query("select b.tapoteur.id from Bannis b left join fetch Tapoteur")
	public List<Integer> findAllTapoteurId();
	
}