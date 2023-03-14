package c.culte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import c.culte.model.Culte;
import c.culte.model.Tapoteur;

public interface IDAOCulte extends JpaRepository<Culte, Integer> {
//	public List<Tapoteur> findAllByTapoteurId(int produitId);

}