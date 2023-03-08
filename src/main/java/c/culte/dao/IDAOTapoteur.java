package c.culte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import c.culte.model.Tapoteur;

public interface IDAOTapoteur extends JpaRepository<Tapoteur,Integer> {

}
