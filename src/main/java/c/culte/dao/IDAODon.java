package c.culte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import c.culte.model.Don;

public interface IDAODon extends JpaRepository<Don,Integer>{
	@Query("SELECT d FROM Don d")
	List<Don> findAllDon();

}
