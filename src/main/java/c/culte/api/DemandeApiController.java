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

import c.culte.dao.IDAODemande;
import c.culte.exception.DemandeBadRequestException;
import c.culte.exception.DemandeNotFoundException;
import c.culte.model.Demande;
import c.culte.request.DemandeRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/demande")
public class DemandeApiController {
	
	@Autowired
	private IDAODemande daoDemande;
		
	//liste des demandes
	@GetMapping
	public List<Demande> findAll() {
		return this.daoDemande.findAll();
	}
	
	//trouver une demande par ID
	@GetMapping("/{id}")
	public Demande findById(@PathVariable int id) {
		return this.daoDemande.findById(id).orElseThrow(DemandeNotFoundException::new);
	}
	
	//Ajouter une demande
	@PostMapping
	public Demande adddemande(@Valid @RequestBody DemandeRequest demandeRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemandeBadRequestException();
		}
		
		Demande demande = new Demande();
		BeanUtils.copyProperties(demandeRequest, demande);
		
		return this.daoDemande.save(demande);
	}
	
	//Modifier une demande
	@PutMapping("/{id}")
	public Demande editdemande(@PathVariable int id, @Valid @RequestBody DemandeRequest demandeRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemandeBadRequestException();
		}
		
		Demande demande = this.daoDemande.findById(id).orElseThrow(DemandeNotFoundException::new);
		BeanUtils.copyProperties(demandeRequest, demande);
		
		return this.daoDemande.save(demande);
	}
	
	//Effacer une demande
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoDemande.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//changer le statut de la demande 
	
	
}
	