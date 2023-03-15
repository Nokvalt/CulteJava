package c.culte.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOEvenement;
import c.culte.dao.IDAOTapoteur;
import c.culte.exception.EvenementBadRequestException;
import c.culte.exception.EvenementNotFoundException;
import c.culte.exception.TapoteurNotFoundException;
import c.culte.model.Activite;
import c.culte.model.Evenement;
import c.culte.model.Fidele;
import c.culte.model.Tapoteur;
import c.culte.request.EvenementRequest;
import c.culte.request.InscriptionRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evenement")
public class EvenementApiController {
	
	@Autowired
	private IDAOEvenement daoEvenement;
	
	@Autowired
	private IDAOTapoteur daoTapoteur;
	
	@GetMapping
	@JsonView(Views.Evenement.class)
	public List<Evenement> findAll()
	{
		return this.daoEvenement.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Evenement.class)
	public Evenement findById(@PathVariable int id) {
		return this.daoEvenement.findById(id).orElseThrow(EvenementNotFoundException::new);
	}
	
	
	@PostMapping
	@JsonView(Views.Evenement.class)
	public Evenement add(@Valid @RequestBody EvenementRequest evenementRequest, BindingResult result) {
	    if (result.hasErrors()) {
	       // throw new EvenementBadRequestException();
	    }
	    
	    Evenement evenement = new Evenement();
	    BeanUtils.copyProperties(evenementRequest, evenement);
	    
	    // Récupérer l'activité correspondante au nomActivite fourni dans la requête
	    try {
	        Activite activite = Activite.valueOf(evenementRequest.getNomActivite());
	        evenement.setActiviteEvent(activite);
	    } catch (IllegalArgumentException e) {
	        throw new EvenementBadRequestException();
	    }
	    
	    return this.daoEvenement.save(evenement);
	}
	
	
	@PutMapping("/{id}")
	@JsonView(Views.Evenement.class)
	public Evenement edit(@PathVariable int id, @Valid @RequestBody EvenementRequest evenementRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EvenementBadRequestException();
		}
		
		Evenement evenement = this.daoEvenement.findById(id).orElseThrow(EvenementNotFoundException::new);
		
		BeanUtils.copyProperties(evenementRequest, evenement);
		
		 try {
		        Activite activite = Activite.valueOf(evenementRequest.getNomActivite());
		        evenement.setActiviteEvent(activite);
		    } catch (IllegalArgumentException e) {
		        throw new EvenementBadRequestException();
		    }
		
		return this.daoEvenement.save(evenement);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoEvenement.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
}
