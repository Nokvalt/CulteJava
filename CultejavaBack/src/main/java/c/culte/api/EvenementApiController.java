package c.culte.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import c.culte.exception.EvenementBadRequestException;
import c.culte.exception.EvenementNotFoundException;
import c.culte.model.Activite;
import c.culte.model.Evenement;
import c.culte.request.EvenementRequest;
import c.culte.response.EvenementResponse;
import c.culte.response.TapoteurResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin("*")
public class EvenementApiController {
	
	@Autowired
	private IDAOEvenement daoEvenement;
	
	@GetMapping
	public List<EvenementResponse> findAll()
	{	
		List<EvenementResponse> responses = new ArrayList();
		List<Evenement> evenements = daoEvenement.findAll();
		
		
		for (Evenement e : evenements) {
			EvenementResponse response = new EvenementResponse();
			BeanUtils.copyProperties(e, response);
			response.setNomActivite(e.getActiviteEvent().name());
			responses.add(response);
		}
		
		return responses;
	}

	@GetMapping("/{id}")
	public EvenementResponse findById(@PathVariable int id) {
		Evenement evenement = daoEvenement.findById(id).orElseThrow(EvenementNotFoundException::new);
		EvenementResponse response = new EvenementResponse();
		
		BeanUtils.copyProperties(evenement, response);
		response.setNomActivite(evenement.getActiviteEvent().name());
		
		return response;
	}
	
	/*@GetMapping("/{id}/tapoteurs")	
	public List<TapoteurResponse> findAllTapoteurByEvenement(@PathVariable int id) {
		
	}*/
	
	
	@PostMapping
	@JsonView(Views.Evenement.class)
	public Evenement add(@Valid @RequestBody EvenementRequest evenementRequest, BindingResult result) {
	    if (result.hasErrors()) {
	       throw new EvenementBadRequestException();
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
