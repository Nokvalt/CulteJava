package c.culte.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import c.culte.model.Bannis;
import c.culte.model.Tapoteur;

public interface IDAOBannis extends JpaRepository<Bannis,Integer> {
	
	public Optional<Bannis> findByTapoteurId(Integer id);
	
	//public List<Integer> findAllId();
	
}