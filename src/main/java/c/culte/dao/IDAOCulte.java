package c.culte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import c.culte.model.Culte;

public interface IDAOCulte extends JpaRepository<Culte, Integer> {

}