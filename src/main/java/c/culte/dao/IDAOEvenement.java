package c.culte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import c.culte.model.Evenement;

public interface IDAOEvenement extends JpaRepository<Evenement, Integer>{

}
