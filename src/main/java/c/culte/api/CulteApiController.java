package c.culte.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOCulte;
import c.culte.model.Culte;
import c.culte.model.Tapoteur;

@RestController
@RequestMapping("/api/culte")
@CrossOrigin("*")
public class CulteApiController {
	
	@Autowired
	private IDAOCulte daoCulte;
	
	@GetMapping
	@JsonView(Views.Culte.class)
	public List<Culte> findAll() {
		return this.daoCulte.findAll();
	}
	
	@GetMapping("/by-tapoteur-id") // /api/culte/by-tapoteur-id?produitId=1
	@JsonView(Views.Culte.class)
	public List<Tapoteur> findAllByTapoteurId(@RequestParam int tapoteurId) {
		return this.daoCulte.findAllByTapoteurId(tapoteurId);
	}
	
	@GetMapping("/by-tapoteur-id/{tapoteurId}") // /api/culte/by-tapoteur-id/1
	@JsonView(Views.Culte.class)
	public List<Tapoteur> findAllByProduitId(@PathVariable int tapoteurId) {
		return this.daoCulte.findAllByTapoteurId(tapoteurId);
	}
	

}
