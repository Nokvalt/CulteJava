package c.culte.api;

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

import c.culte.dao.IDAODemande;
import c.culte.dao.IDAOTapoteur;
import c.culte.exception.DemandeBadRequestException;
import c.culte.exception.DemandeNotFoundException;
import c.culte.model.Demande;
import c.culte.model.Indenteur;
import c.culte.request.DemandeRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/demande")
@CrossOrigin("*")
public class DemandeApiController {
	
	@Autowired
	private IDAODemande daoDemande;
	@Autowired
	private IDAOTapoteur daoTapoteur;
		
	//liste des demandes
	@GetMapping
	@JsonView(Views.Demande.class)
	public List<Demande> findAll() {
		return this.daoDemande.findAll();
	}
	
	/*//trouver une demande par ID
	@GetMapping("/{id}")
	@JsonView(Views.Demande.class)
	public Demande findById(@PathVariable int id) {
		return this.daoDemande.findById(id).orElseThrow(DemandeNotFoundException::new);
	}*/
	
	//Ajouter une demande
	@PostMapping // TODO a supprimer id ?
	@JsonView(Views.Demande.class)
	public Demande adddemande(@Valid @RequestBody DemandeRequest demandeRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemandeBadRequestException();
		}
		
	
		Demande demande = new Demande();
		Indenteur indenteur = (Indenteur) daoTapoteur.findById(demandeRequest.getIndenteurid()).orElseThrow(DemandeNotFoundException::new);
		// Todo regaerder l'indenteur
		BeanUtils.copyProperties(demandeRequest, demande);
		
		demande.setIndenteur(indenteur);
		
		return this.daoDemande.save(demande);
		// TODO chercher l'indenteur avec son id puis l'affecter à la demande
	}
	
	
	//Modifier une demande
	@PutMapping("/{id}")
	@JsonView(Views.Demande.class)
	public Demande editdemande(@PathVariable int id, @Valid @RequestBody DemandeRequest demandeRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemandeBadRequestException();
		}
		
		Demande demande = this.daoDemande.findById(id).orElseThrow(DemandeNotFoundException::new);
		BeanUtils.copyProperties(demandeRequest, demande);
		
		return this.daoDemande.save(demande);
	}
	
	/*@PutMapping("/statut/{id}")
	@JsonView(Views.Demande.class)
	public Demande editdemandestatut(@PathVariable int id, @Valid @RequestBody DemandeRequest demandeRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemandeBadRequestException();
		}
		
		Demande demande = this.daoDemande.findById(id).orElseThrow(DemandeNotFoundException::new);
		BeanUtils.copyProperties(demandeRequest, demande);
		
		return this.daoDemande.save(demande);
	}*/
	
	//Effacer une demande
	@DeleteMapping("/{id}")
	@JsonView(Views.Demande.class)
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
	
	
	
	
}
	